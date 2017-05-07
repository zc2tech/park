<?php
class Reserve_model extends CI_Model {
	
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
	function getByRequestUserId($request_user_id,$array = false) {
		$query = $this->db->get_where('reserve', array('request_user_id' => $request_user_id), 1);
		if ($query->num_rows() === 0 )  return '';
		if ($array) {
			return $query->row_array();
		} else {
			return $query->row();
		}		
	}
	
	/**
	 * 根据访客，进行关联查询
	 * @param unknown $fromUserId
	 * @param unknown $toUserId
	 * @return unknown
	 */
	function searchReserveByRequestUser($guestId) {
		$param = array();
		
		$sql = 'SELECT re.reserve_id,re.space_id,pa.space_no, re.owner_id, ow.nickname as owner_name,'
    			. 're.warrantor_id, wa.nickname as warrantor_name, rent.price '
				. 'FROM reserve re INNER JOIN park_space pa ON re.space_id = pa.space_id '
				. 'INNER JOIN tuser ow ON re.owner_id = ow.user_id '
    			. 'INNER JOIN tuser wa ON re.warrantor_id = wa.user_id ' 
    			. 'INNER JOIN rent ON re.rent_id = rent.rent_id ' 
				. 'WHERE request_user_id = ?; ';
		//echo $sql;
		$query = $this->db->query($sql,array($guestId));
		return $query->result();
	}
	
}