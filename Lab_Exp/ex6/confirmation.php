<?php
session_start();
$orderDetails = $_SESSION['order_details'] ?? [];
$total = $_SESSION['total'] ?? 0;
session_unset();
session_destroy();
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Confirmation</title>
    <style>
        body {
            font-family:'Times New Roman', Times, serif;
            margin: 0;
            padding: 0;
            background-color: #cce7ff;
            color: #333;
        }
        h1 {
            text-align: center;
            margin: 20px 0;
        }
        .container {
            width: 40%;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
        }
        ul {
            padding-left: 20px;
        }
        ul li {
            margin-bottom: 5px;
            color: #555;
        }
        .total {
            font-size: 1.2em;
            margin-top: 20px;
        }
        a {
            display: inline-block;
            text-decoration: none;
            color: #fff;
            background-color: #4CAF50;
            padding: 10px 15px;
            border-radius: 5px;
            margin-top: 20px;
        }
        a:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h1>Order Confirmation</h1>
    <div class="container">
        <?php if (!empty($orderDetails)): ?>
            <h2>Your Order:</h2>
            <ul>
                <?php foreach ($orderDetails as $detail): ?>
                    <li><?php echo $detail; ?></li>
                <?php endforeach; ?>
            </ul>
            <h3>Total: ₹<?php echo $total; ?></h3>
        <?php else: ?>
            <p>No order details found.</p>
        <?php endif; ?>
        <a href="menu1.php">Back to Menu</a>
    </div>
</body>
</html>
