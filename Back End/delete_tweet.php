<?php
header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Methods: GET, POST');
header("Access-Control-Allow-Headers: X-Requested-With");

include("connection.php");

if(isset($_POST["User_id"]) && $_POST["User_id"] != "" && isset($_POST["Tweet_id"]) && $_POST["Tweet_id"] != "" ){
    $User_id = $_POST["User_id"];
    $Tweet_id = $_POST["Tweet_id"];
}else{
    $response = [];
    $response["success"] = false;   
    echo json_encode($response);
   
    return; 
}

$query = $mysqli->prepare("UPDATE tweets SET Is_deleted = Is_deleted - 1  WHERE User_id=? && Tweet_id = ?");
$query->bind_param("ii", $User_id, $Tweet_id);
$query->execute();

$response = [];
$response["success"] = true;

echo json_encode($response);
