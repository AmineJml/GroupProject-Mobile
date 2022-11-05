<?php
include("connection.php");
//tweet_id
//2 steps
//first get the like count 
//second increment it by one and update it in the database

if(isset($_POST["Tweet_id"]) && $_POST["Tweet_id"] != ""){
    $Tweet_id = $_POST["Tweet_id"];

}else{
    $response = [];
    $response["success"] = false;   
    echo json_encode($response);
    return; 
}

$query = $mysqli->prepare("UPDATE tweets SET Like_count = Like_count + 1 WHERE Tweet_id = ?");
$query->bind_param("i",  $Tweet_id );
$query->execute();

$response = [];
$response["success"] = true;
echo json_encode($response);


