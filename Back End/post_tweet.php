<?php

header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Methods: GET, POST');
header("Access-Control-Allow-Headers: X-Requested-With");

include("connection.php");

if(isset($_POST["User_id"]) && $_POST["User_id"] != "" && isset($_POST["Tweet"]) && $_POST["Tweet"] != "" ){
    $User_id = $_POST["User_id"];
    $Tweet = $_POST["Tweet"];
}else{
    $response = [];
    $response["success"] = false;   
    echo json_encode($response);
    return; 
}
$Is_deleted = 1;
$like_count = 0;

$query = $mysqli->prepare("INSERT INTO tweets(User_id, Tweet, Is_deleted, Like_count) VALUES (?, ?, ?, ?)");
$query->bind_param("isbi", $User_id, $Tweet, $Is_deleted, $like_count);
$query->execute();

$response = [];
$response["success"] = true;

echo json_encode($response);
