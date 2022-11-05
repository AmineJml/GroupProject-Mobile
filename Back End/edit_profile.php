<?php
include("connection.php");
//Username can be changed
//FName, LName, password
// if(isset($_POST["User_id"]) && $_POST["User_id"] != "" && isset($_POST["Username"]) && $_POST["Username"] != "" && isset($_POST["FName"]) && $_POST["FName"] != "" && isset($_POST["LName"]) && $_POST["LName"] != "" && isset($_POST["Password"]) && $_POST["Password"] != ""  ){
//     $User_id = $_POST["User_id"];
//     $Username = $_POST["Username"];
//     $FName = $_POST["FName"];
//     $LName = $_POST["LName"];
//     $Password = $_POST["Password"];
// }
if(isset($_POST["User_id"]) && $_POST["User_id"] != "" && isset($_POST["FName"]) && $_POST["FName"] != ""){
    $User_id = $_POST["User_id"];
    $FName = $_POST["FName"];
}else{
    $response = [];
    $response["success"] = false;   
    echo json_encode($response);
    return; 
}


$query = $mysqli->prepare("UPDATE users SET FName=? , LName=? WHERE User_id=?");
//$query = $mysqli->prepare("UPDATE users SET FName=? WHERE User_id=?");
$query->bind_param("ssi", $FName, LName, $User_id);
$query->execute();

$response = [];
$response["success"] = true;

echo json_encode($response);
