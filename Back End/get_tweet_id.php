<?php 
include("connection.php");

if(isset($_GET["id"])){
    $id = $_GET["id"];
}else{
    die("Don't try to mess around bro ;) ");
}

$query = $mysqli->prepare("Select * from users WHERE User_id = ?");
$query->bind_param("i", $id);
$query->execute();

$array = $query->get_result();
$response = [];
while($article = $array->fetch_assoc()){
    $response[] = $article;
}

if($response[1] == null){
    die("shhesh its empty");
}

echo json_encode($response);