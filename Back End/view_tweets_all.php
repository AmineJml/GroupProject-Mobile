<?php
header('Access-Control-Allow-Origin: *');
header('Access-Control-Allow-Methods: GET, POST');
header("Access-Control-Allow-Headers: X-Requested-With");

include("connection.php");
$query = $mysqli->prepare("SELECT * From tweets");
$query->execute();

$results = $query->get_result();
$response = [];

while($tweets = $results->fetch_assoc()){
    $response[] = $tweets;
}

echo json_encode($response);

