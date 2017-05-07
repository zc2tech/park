<?php ?>
<!DOCTYPE html>
<html>
<head>
<title>访客租用信息</title>
<link href="/css/bootstrap.min.css" rel="stylesheet">
<script src="/scripts/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<h1>访客租用信息</h1>

<h2>访客信息</h2>
<div class="row h3 text-left">
  <div class="col-sm-3">phone</div>
  <div class="col-sm-9"><?php echo $tuser->phone ?></div>
</div>

<div class="row h3 text-left">
  <div class="col-sm-3">mail</div>
  <div class="col-sm-9"><?php echo $tuser->mail ?></div>
</div>

<h2>租用信息</h2>

<div class="table-responsive">
  <table class="table">
  <tr><th>车位</th><th>价格(每分钟)</th><th>出租用户</th><th>担保人</th><th>状态</th><th>操作</th></tr>
  <?php foreach($infos as $info)  {?>
	<tr>
	<td><?php echo $info->space_id . ' ' . $info->space_no ?></td>
	<td><?php echo $info->price ?></td>
	<td><?php echo $info->owner_id . ' ' . $info->owner_name ?></td>
	<td><?php echo $info->warrantor_id. ' ' . $info->warrantor_name?></td>
	<td><?php echo $info->warrantor_id. ' ' . $info->warrantor_name?></td>
	</tr>
  <?php } ?>
  </table>
</div>

<h3><a href="<?php echo site_url("guest_door/index") ?>" >车位信息</a></h3>
<h3><a href="<?php echo site_url("guest_door/index") ?>" >回到菜单</a></h3>
</div>
</body>
</html>