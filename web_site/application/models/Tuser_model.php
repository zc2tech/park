<?php
class Tuser_model extends CI_Model {
	
	public function __construct()
	{
		$this->load->database();
	}
	
    /**
     * 电话号码取得用户信息
     * @param unknown $tel
     * @param string $array
     * @return string|unknown
     */
	function getRowByTel($tel,$array = false) {
		$query = $this->db->get_where('tuser', array('phone' => $tel), 1);
		if ($query->num_rows() === 0 )  return '';
		if ($array) {
			return $query->row_array();
		} else {
			return $query->row();
		}		
	}
	
}