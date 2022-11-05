<?php
include("connection.php");
//tweet_id
//2 steps
//first get the like count 
//second increment it by one and update it in the database

if(isset($_POST["tweet_id"]) && $_POST["tweet_id"] != ""){
    $tweet_id = $_POST["tweet_id"];

}else{
    $response = [];
    $response["success"] = false;   
    echo json_encode($response);
    return; 
}

$query = $mysqli->prepare("SELECT Like_count FROM tweets WHERE tweet_id = ?");
$query->bind_param("i", $tweet_id);
$query->execute();

$results = $query->get_result();

while($Like_count = $results->fetch_assoc()){
    $response = $Like_count;
}

echo json_encode($response);


