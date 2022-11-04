<?php

include("connection.php");
$query = $mysqli->prepare("SELECT * From tweets");
$query->execute();

$results = $query->get_result();
$response = [];

while($tweets = $results->fetch_assoc()){
    $response[] = $tweets;
}

echo json_encode($response);

