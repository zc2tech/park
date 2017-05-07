<?php ?>
<!DOCTYPE html>
<html>
<head>
<title>输入电话号码</title>
<link href="/css/bootstrap.min.css" rel="stylesheet">
<script src="/scripts/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<h1>输入电话号码</h1>

<?php echo isset($error)?$error:'';?>

<?php echo form_open('guest_door/identify_phone');?>

<input type="text" name="phone" size="20" />

<br /><br />

<input type="submit" value="identify" />

<?php echo '</form>' ?>

<h3><a href="<?php echo site_url("guest_manage/create") ?>" >追加访客</a></h3>
<h3><a href="<?php echo site_url("guest_door/index") ?>" >回到菜单</a></h3>
</div>
</body>
</html>