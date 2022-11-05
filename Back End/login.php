<?php
header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Methods: GET, POST');
header("Access-Control-Allow-Headers: X-Requested-With");

include("connection.php");

if(isset($_POST["Username"])   ){
    $Username = $_POST["Username"];
   // $Password = $_POST["Password"];
}else{
     $response = [];
     $response["success"] = false;   
     echo json_encode($response);
     return; 
 }

$query = $mysqli->prepare("Select * from users WHERE Username = ?");
$query->bind_param("s", $Username);
$query->execute();

$array = $query->get_result();
$response = [];
while($tweets = $array->fetch_assoc()){
    $response[] = $tweets;
}

if(!$response ){ //list is empty
    $response["success"] = "user_does_not_exit";   
}

else{
  
    $response["success"] = true;   

}
echo json_encode($response);

