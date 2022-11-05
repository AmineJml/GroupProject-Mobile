<?php 
header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Methods: GET, POST');
header("Access-Control-Allow-Headers: X-Requested-With");

include("connection.php");

if(isset($_GET["id"])){
    $id = $_GET["id"];
}else{
    $response = [];
    $response["success"] = false;   
    echo json_encode($response);
    return;  
}

$query = $mysqli->prepare("Select * from tweets WHERE User_id = ?");
$query->bind_param("i", $id);
$query->execute();

$array = $query->get_result();
$response = [];
while($tweets = $array->fetch_assoc()){
    $response[] = $tweets;
}

if($response[1] == null){
    die("There are no tweets with this user");
}

echo json_encode($response);