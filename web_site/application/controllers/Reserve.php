<?php
/**
 * 有关预约信息的处理
 *
 */
class reserve extends CI_Controller {
	
	public function __construct()
	{
		parent::__construct();
		$this->load->helper('url_helper');
	}
	
	public function view($guestId = FALSE)
	{
		$this->load->model('tuser_model');
		if($phone == "") {
			$this->load->view('guest/door/guest_info_error',array("phone" => ''));
			return;
		}
		
		$guest =  $this->tuser_model->getRowByTel($phone);
		if ($guest == '') {
			$this->load->view('guest/door/guest_info_error',array("phone" => ''));
			return;
		}
		
		//$data = array("guest" => $this->tuser_model->)
		$this->load->view('guest/door/guest_info',array('tuser' => $guest));
	}
}