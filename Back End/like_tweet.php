<?php
include("connection.php");
//tweet_id
if(isset($_POST["tweet_id"]) && $_POST["tweet_id"] != ""){
    $tweet_id = $_POST["tweet_id"];

}else{
    $response = [];
    $response["success"] = false;   
    echo json_encode($response);
    return; 
}

$Like_count = $mysqli->prepare("Select Like_count FROM tweets WHERE Tweet_id = ?");
die($Like_count);
// $query = $mysqli->prepare("UPDATE tweets SET Like_count=? WHERE Tweet_id=?");
// //$query = $mysqli->prepare("UPDATE users SET FName=? WHERE User_id=?");
// $query->bind_param("si", $FName, $Tweet_id);
// $query->execute();

// $response = [];
// $response["success"] = true;

// echo json_encode($response);
