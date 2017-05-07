<h2><?php echo $title; ?></h2>

<?php echo validation_errors(); ?>

<?php echo form_open('news/create'); ?>

    <label for="title">Title</label>
    <input type="input" name="title" /><br />

    <label for="content">Content</label>
    <textarea name="content"></textarea><br />

    <input type="submit" name="submit" value="Create news item" />

</form>