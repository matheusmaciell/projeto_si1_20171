package com.ufcg.si1.model;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ufcg.si1.util.ObjWrapper;

public class PrefeituraNormal implements SituacaoPrefeitura {
	
	 public ObjWrapper<Integer> getSituacaoGeral(double numQueixasAbertas, int queixaService) {	 
         if (numQueixasAbertas / queixaService > 0.2) {
             return new ObjWrapper<Integer>(0);
         } else {
             if (numQueixasAbertas/ queixaService > 0.1) {
                 return new ObjWrapper<Integer>(1);
             }
             
             return new ObjWrapper<Integer>(2);
         }
		 
	 }

}
