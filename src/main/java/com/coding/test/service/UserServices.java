package com.coding.test.service;

import com.coding.test.CustomException;
import com.coding.test.Response;
import com.coding.test.entity.TBL_USER;
import com.coding.test.repository.TblUserRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class UserServices {
    @Autowired
    TblUserRepository tblUserRepository;

    public Response setDataUser(HashMap<String, Object> param){
        Response response = new Response();

        try {
            TBL_USER val = tblUserRepository.findTopByUserid(Integer.valueOf(String.valueOf(param.get("userId"))));
            if(val != null){
                throw new CustomException("UserID sudah digunakan");
            }

            TBL_USER val2 = tblUserRepository.findTopByUsername(String.valueOf(param.get("username")));
            if(val2 != null){
                throw new CustomException("Username sudah digunakan");
            }

            TBL_USER tblUser = new TBL_USER();
            tblUser.setUserid(Integer.valueOf(String.valueOf(param.get("userId"))));
            tblUser.setNamalengkap(String.valueOf(param.get("namaLengkap")));
            tblUser.setUsername(String.valueOf(param.get("username")));
            tblUser.setPassword(Base64.encodeBase64String(String.valueOf(param.get("password")).getBytes()));
            tblUser.setStatus(String.valueOf(param.get("status")).charAt(0));
            tblUserRepository.save(tblUser);

            response.setStatus(true);
            response.setMessage("Sukses memembuat user baru");
        }catch (CustomException e){
            response.setStatus(false);
            response.setMessage(e.getMessage());
        }catch (Exception e){
            response.setStatus(false);
            response.setMessage("Gagal memembuat user baru");
            e.printStackTrace();
        }

        return response;
    }

    public Response getDataUser(String userId){
        Response response = new Response();

        try {
            List<TBL_USER> tblUserList = new ArrayList<>();
            if(userId.equals("")){
                tblUserList = tblUserRepository.findAll();
            }else if(userId != null) {
                tblUserList = tblUserRepository.findAllByUserid(Integer.valueOf(userId));
            }

            if(tblUserList.isEmpty()){
                throw new CustomException("User tidak ditemukan");
            }

            response.setResult(tblUserList);
            response.setStatus(true);
            response.setMessage("Sukses mendapatkan data user");
        }catch (CustomException e){
            response.setStatus(false);
            response.setMessage(e.getMessage());
        }catch (Exception e){
            response.setStatus(false);
            response.setMessage("Gagal mendapatkan data user");
            e.printStackTrace();
        }

        return response;
    }

    public Response delDataUser(String userId){
        Response response = new Response();

        try {
            TBL_USER tbl_user = tblUserRepository.findTopByUserid(Integer.valueOf(userId));
            if(tbl_user == null){
                throw new CustomException("User tidak ditemukan");
            }
            tblUserRepository.delete(tbl_user);

            response.setStatus(true);
            response.setMessage("Sukses menghapus data user");
        }catch (CustomException e){
            response.setStatus(false);
            response.setMessage(e.getMessage());
        }catch (Exception e){
            response.setStatus(false);
            response.setMessage("Gagal menghapus data user");
            e.printStackTrace();
        }

        return response;
    }
}
