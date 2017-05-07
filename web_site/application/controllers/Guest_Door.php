<?php
/**
 * 客户在大门口的主处理
 * 
*/
class guest_door extends CI_Controller {
	public function __construct()
	{
		parent::__construct();
// 		$this->load->model('news_model');
 		$this->load->helper('url_helper');
 		$this->load->helper(array('form', 'url'));
	}
	
	/**
	 * 主菜单
	 */
	public function index()
	{
		$this->load->view('guest/door/index');
	}
	
	/**
	 * 外来人员身份识别
	 */
	public function identify()
	{
		$this->load->view('guest/door/identify_menu');
	}
	
	/**
	 * 外来人员身份识别Phone
	 */
	public function identify_phone_input()
	{
		$this->load->view('guest/door/identify_phone_input');
	}

	/**
	 * POST 外来人员身份识别 
	 */
	public function identify_phone()
	{
		$this->load->model('tuser_model');
		$phone= $this->input->post('phone');
		
		if($phone =='') {
			$this->load->view('identify_phone_input.phpr',array("error" => '请输入电话号码'));
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
	
	
	/**
	 * 外来人员身份二维码识别，图片输入界面
	 */
	public function identify_barcode_input()
	{
		$this->load->view('guest/door/identify_barcode_input',array("error" => ""));
	}
	
	/**
	 * 外来人员身份二维码识别处理
	 */
	public function identify_barcode()
	{
		$this->load->view('guest/door/identify_barcode_result');
	}
	
	/**
	 * 二维码识别或者电话输入完之后，显示访客信息
	 */
	public function guest_info($phone = "")
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
	
	public function test_gen_qrcode()
	{
		$this->load->library('ciqrcode');
		
		$params['data'] = 'This is a text to encode become QR Code';
		$params['level'] = 'H';
		$params['size'] = 10;
		$params['savename'] = FCPATH.'tes.png';
		$this->ciqrcode->generate($params);
		
		echo '<img src="'.base_url().'tes.png" />';	
	}
	
	public function test_decode()
	{
		$this->load->library('qrdecoder');
		
// 		$params['data'] = 'This is a text to encode become QR Code';
// 		$params['level'] = 'H';
// 		$params['size'] = 10;
// 		$params['savename'] = FCPATH.'tes.png';
		$text = $this->qrdecoder->decode(FCPATH. 'barcode\a.jpg');
		
		echo 'The code is:' . $text;
	}
	
	public function do_upload()
	{
		$config['upload_path']          = './barcode/upload';
		//$config['allowed_types']        = 'gif|jpg|png';
		$config['allowed_types']        = '*';
		$config['max_size']             = 100;
		$config['max_width']            = 1024;
		$config['max_height']           = 768;
		// $config['detect_mime']          = false; // I don't know why this option not work, seems a bug
		
		$this->load->library('upload', $config);
		
		if ( ! $this->upload->do_upload('userfile'))
		{
			$error = array('error' => $this->upload->display_errors());
			
			$this->load->view('/guest/door/identify_barcode_input', $error);
		}
		else
		{
			// 首先要检验一下二维码
			$this->load->library('qrdecoder');
			$fileinfo =$this->upload->data();
			$text = $this->qrdecoder->decode($fileinfo['full_path']);
			
			$data = array('tel' => $text);
			
			$this->load->view('/guest/door/identify_barcode_upload_success', $data);
		}
	}
}