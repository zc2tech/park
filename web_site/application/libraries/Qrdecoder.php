<?php
/**
 * PHP QR Code porting for Codeigniter
 *
 * @package        	CodeIgniter
 * @subpackage    	Libraries
 * @category    	Libraries
 * @porting author	dwi.setiyadi@gmail.com
 * @original author	http://phpqrcode.sourceforge.net/
 *
 * @version		1.0
 */

class Qrdecoder
{
	function __construct($config = array()) {
		// call original library
		$this->initialize($config);
	}
	
	public function initialize($config = array()) {
		// do nothing for now
		require __DIR__ . "/vendor/autoload.php";
	}
	
	
	function decode($image_path) {
		$qrcode = new QrReader($image_path);
		return $qrcode->text(); //return decoded text from QR Code
	}
}