# eCommerce2

<?php

$connection = new mysqli("","","","");    //pass the name of "server","username","password","database name"         
$sqlCommand = $connection ->prepare("select * from product_ecom where id = ?");
$sqlCommand ->bind_param("i", $_GET["id"]);
$sqlCommand ->execute();


$result = $sqlCommand->get_result();
$rowOfData = $result->fetch_assoc();


//as JSON
echo json_encode($rowOfData);    //convert as json object


]
//retrieve data as JSON Array
<?php

$connection = new mysqli("","","","");
$sqlCommand = $connection->prepare("select * from product_ecom");
$sqlCommand->execute();

$result = $sqlCommand->get_result();
$products = array();

while ($rowOfData =$result->fetch_assoc())
{
    array_push($products, $rowOfData);
}

echo json_encode($products);
