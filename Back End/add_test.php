<?php
include("connection.php");

if(isset($_POST['test']) ){
    $test = $_POST['test'];
}
    else{
        $response = [];
        $response["success"] = false;   
        echo json_encode($response);
        return; 
    }

$query = $mysqli->prepare("INSERT INTO tests(test) VALUES (?)");
$query->bind_param("s", $test);
$query->execute();

$response = [];
$response["success"] = true;

echo json_encode($response);
