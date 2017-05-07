<?php ?>
<!DOCTYPE html>
<html>
<head>
<title>上传二维码</title>
<link href="/css/bootstrap.min.css" rel="stylesheet">
<script src="/scripts/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<h1>上传二维码</h1>

<?php echo $error;?>

<?php echo form_open_multipart('guest_door/do_upload');?>

<input type="file" name="userfile" size="20" />

<br /><br />

<input type="submit" value="upload" />

<?php echo "</form>" ?>


<h3><a href="<?php echo site_url("guest_door/index") ?>" >回到菜单</a></h3>
</div>
</body>
</html>