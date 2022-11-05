<?php 
header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Methods: GET, POST');
header("Access-Control-Allow-Headers: X-Requested-With");

include("connection.php");

if(isset($_GET["User_id"])){
    $User_id = $_GET["User_id"];
}else{
    $response = [];
    $response["success"] = false;   
    echo json_encode($response);
    return;  
}

$query = $mysqli->prepare("Select Tweet from tweets WHERE User_id = ?");
$query->bind_param("i", $User_id);
$query->execute();

$array = $query->get_result();
$response = [];
while($tweets = $array->fetch_assoc()){
    $response[] = $tweets;
}

if($response[0] == null){
    die("This user does not have any tweets");
    $response["success"] = false;
}

echo json_encode($response);