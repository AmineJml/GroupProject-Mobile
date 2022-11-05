<?php
include("connection.php");

if(isset($_POST["User_id"]) && $_POST["User_id"] != "" && isset($_POST["delete"]) && $_POST["delete"] != "" ){
    $User_id = $_POST["User_id"];
    $Is_deleted = $_POST["delete"];
}else{--
    $response = [];
    $response["success"] = false;   
    echo json_encode($response);
    return; 
}
//no need to add if condition if
$query = $mysqli->prepare("INSERT INTO tweets(User_id, Is_deleted) VALUES (?, ?, ?, ?)");
$query->bind_param("ib", $User_id, $Is_deleted);
$query->execute();

$response = [];
$response["success"] = true;

echo json_encode($response);
