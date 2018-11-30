/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;


import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.sql.SQLException;

/**
 *
 * @author FRANCISCONAVA
 */
@Named(value = "acuInfluenzaDTO")
@SessionScoped
public class AcuInfluenzaDTO implements Serializable{

    /**
     * Creates a new instance of LogInfluenzaDTO
     */
   
    
    @Inject
    private usuarioDTO usuario;
    private String id_log_influ;
    private String  T1_A_A;
    private String  T1_A_H;
    private String  T1_H1_A;
    private String  T1_H1_H;
    private String  T1_H3_A;
    private String  T1_H3_H;
    private String  T1_B_A;
    private String  T1_B_H;
    private String  T2_24;
    private String  T2_H_M;
    private String  T2_I_M;
    private String  T2_C_UTI;
    private String  T2_C_U;
    private String  T3_DF_NA;
    private String  T3_DF_PCR;
    private String  T4_DF_A;
    private String  T4_DF_H1;
    private String  T4_DF_H3;
    private String  T4_DF_B;
    private String  T5_PS_A_A;
    private String  T5_PS_A_H;
    private String  T5_PS_H1_A;
    private String  T5_PS_H1_H;
    private String  T5_PS_H3_A;
    private String  T5_PS_H3_H; 
    private String  T5_PS_B_A;
    private String  T5_PS_B_H;
    private String  T6_V_TRGB;
    private String  T6_V_VAPS;
    private String  T6_V_PSV;
    private String  T6_V_VAP;
    private String  T6_V_VAF;
    private String  T7_OA_TP_A;
    private String  T7_OA_TP_H;
    private String  T7_OA_EI_A;
    private String  T7_OA_EI_H;
    private String  FECHA;
    private String suma1;
    private String suma2;
    private String suma3;
    private String suma4;
    private String suma5;
    private String suma6;
    private String suma7;
    private String suma8;
    private String suma9;
    private String suma10;
    private String suma11;
    

    public String getId_log_influ(){
        return id_log_influ;
    }

    public void setId_log_influ(String id_log_influ) {
        this.id_log_influ = id_log_influ;
    }

    public String getT1_A_A() {
        return T1_A_A;
    }

    public void setT1_A_A(String T1_A_A) throws SQLException{
                this.T1_A_A = T1_A_A;
    }

    public String getT1_A_H() {
        return T1_A_H;
    }

    public void setT1_A_H(String T1_A_H) {
        this.T1_A_H = T1_A_H;
    }

    public String getT1_H1_A() {
        return T1_H1_A;
    }

    public void setT1_H1_A(String T1_H1_A) {
        this.T1_H1_A = T1_H1_A;
    }

    public String getT1_H1_H() {
        return T1_H1_H;
    }

    public void setT1_H1_H(String T1_H1_H) {
                this.T1_H1_H = T1_H1_H;
    }

    public String getT1_H3_A() {
        return T1_H3_A;
    }

    public void setT1_H3_A(String T1_H3_A) {
            this.T1_H3_A = T1_H3_A;
    }

    public String getT1_H3_H() {
        return T1_H3_H;
    }

    public void setT1_H3_H(String T1_H3_H) {
        this.T1_H3_H = T1_H3_H;
    }

    public String getT1_B_A() {
        return T1_B_A;
    }

    public void setT1_B_A(String T1_B_A) {
        this.T1_B_A = T1_B_A;
    }

    public String getT1_B_H() {
        
        return T1_B_H;
    }

    public void setT1_B_H(String T1_B_H) {
                this.T1_B_H = T1_B_H;
    }

    public String getT2_24() {
        return T2_24;
    }

    public void setT2_24(String T2_24) {
                this.T2_24 = T2_24;
    }

    public String getT2_H_M() {
        return T2_H_M;
    }

    public void setT2_H_M(String T2_H_M) {
                this.T2_H_M = T2_H_M;
    }

    public String getT2_I_M() {
        return T2_I_M;
    }

    public void setT2_I_M(String T2_I_M) {
        this.T2_I_M = T2_I_M;
    }

    public String getT2_C_UTI() {
        return T2_C_UTI;
    }

    public void setT2_C_UTI(String T2_C_UTI) {
        this.T2_C_UTI = T2_C_UTI;
    }

    public String getT2_C_U() {
        return T2_C_U;
    }

    public void setT2_C_U(String T2_C_U) {
        this.T2_C_U = T2_C_U;
    }

    public String getT3_DF_NA() {
        return T3_DF_NA;
    }

    public void setT3_DF_NA(String T3_DF_NA) {
        this.T3_DF_NA = T3_DF_NA;
    }

    public String getT3_DF_PCR() {
        return T3_DF_PCR;
    }

    public void setT3_DF_PCR(String T3_DF_PCR) {
        this.T3_DF_PCR = T3_DF_PCR;
    }

    public String getT4_DF_A() {
        return T4_DF_A;
    }

    public void setT4_DF_A(String T4_DF_A) {
        this.T4_DF_A = T4_DF_A;
    }

    public String getT4_DF_H1() {
        return T4_DF_H1;
    }

    public void setT4_DF_H1(String T4_DF_H1) {
        this.T4_DF_H1 = T4_DF_H1;
    }

    public String getT4_DF_H3() {
        return T4_DF_H3;
    }

    public void setT4_DF_H3(String T4_DF_H3) {
        this.T4_DF_H3 = T4_DF_H3;
    }

    public String getT4_DF_B() {
        return T4_DF_B;
    }

    public void setT4_DF_B(String T4_DF_B) {
        this.T4_DF_B = T4_DF_B;
    }

    public String getT5_PS_A_A() {
        return T5_PS_A_A;
    }

    public void setT5_PS_A_A(String T5_PS_A_A) {
        this.T5_PS_A_A = T5_PS_A_A;
    }

    public String getT5_PS_A_H() {
        return T5_PS_A_H;
    }

    public void setT5_PS_A_H(String T5_PS_A_H) {
        this.T5_PS_A_H = T5_PS_A_H;
    }

    public String getT5_PS_H1_A() {
        return T5_PS_H1_A;
    }

    public void setT5_PS_H1_A(String T5_PS_H1) {
        this.T5_PS_H1_A = T5_PS_H1;
    }

    public String getT5_PS_H1_H() {
        return T5_PS_H1_H;
    }

    public void setT5_PS_H1_H(String T5_PS_H1_H) {
        this.T5_PS_H1_H = T5_PS_H1_H;
    }

    public String getT5_PS_H3_A() {
        return T5_PS_H3_A;
    }

    public void setT5_PS_H3_A(String T5_PS_H3_A) {
        this.T5_PS_H3_A = T5_PS_H3_A;
    }

    public String getT5_PS_H3_H() {
        return T5_PS_H3_H;
    }

    public void setT5_PS_H3_H(String T5_PS_H3_H) {
        this.T5_PS_H3_H = T5_PS_H3_H;
    }

    public String getT5_PS_B_A() {
        return T5_PS_B_A;
    }

    public void setT5_PS_B_A(String T5_PS_B_A) {
        this.T5_PS_B_A = T5_PS_B_A;
    }

    public String getT5_PS_B_H() {
        return T5_PS_B_H;
    }

    public void setT5_PS_B_H(String T5_PS_B_H) {
        this.T5_PS_B_H = T5_PS_B_H;
    }

    public String getT6_V_TRGB() {
        return T6_V_TRGB;
    }

    public void setT6_V_TRGB(String T6_V_TRGB) {
        this.T6_V_TRGB = T6_V_TRGB;
    }

    public String getT6_V_VAPS() {
        return T6_V_VAPS;
    }

    public void setT6_V_VAPS(String T6_V_VAPS) {
        this.T6_V_VAPS = T6_V_VAPS;
    }

    public String getT6_V_PSV() {
        return T6_V_PSV;
    }

    public void setT6_V_PSV(String T6_V_PSV) {
        this.T6_V_PSV = T6_V_PSV;
    }

    public String getT6_V_VAP() {
        return T6_V_VAP;
    }

    public void setT6_V_VAP(String T6_V_VAP) {
        this.T6_V_VAP = T6_V_VAP;
    }

    public String getT6_V_VAF() {
        return T6_V_VAF;
    }

    public void setT6_V_VAF(String T6_V_VAF) {
        this.T6_V_VAF = T6_V_VAF;
    }

    public String getT7_OA_TP_A() {
        return T7_OA_TP_A;
    }

    public void setT7_OA_TP_A(String T7_OA_TP_A) {
        this.T7_OA_TP_A = T7_OA_TP_A;
    }

    public String getT7_OA_TP_H() {
        return T7_OA_TP_H;
    }

    public void setT7_OA_TP_H(String T7_OA_TP_H) {
        this.T7_OA_TP_H = T7_OA_TP_H;
    }

    public String getT7_OA_EI_A() {
        return T7_OA_EI_A;
    }

    public void setT7_OA_EI_A(String T7_OA_EI_A) {
        this.T7_OA_EI_A = T7_OA_EI_A;
    }

    public String getT7_OA_EI_H() {
        return T7_OA_EI_H;
    }

    public void setT7_OA_EI_H(String T7_OA_EI_H) {
        this.T7_OA_EI_H = T7_OA_EI_H;
    }

    public String getFECHA() {
        return FECHA;
    }

    public void setFECHA(String FECHA) {
        this.FECHA = FECHA;
    }

    public String getSuma1() {
        return suma1;
    }

    public void setSuma1(String suma1) {
        this.suma1 = suma1;
    }

    public String getSuma2() {
        return suma2;
    }

    public void setSuma2(String suma2) {
        this.suma2 = suma2;
    }

    public String getSuma3() {
        return suma3;
    }

    public void setSuma3(String suma3) {
        this.suma3 = suma3;
    }

    public String getSuma4() {
        return suma4;
    }

    public void setSuma4(String suma4) {
        this.suma4 = suma4;
    }

    public String getSuma5() {
        return suma5;
    }

    public void setSuma5(String suma5) {
        this.suma5 = suma5;
    }

    public String getSuma6() {
        return suma6;
    }

    public void setSuma6(String suma6) {
        this.suma6 = suma6;
    }

    public String getSuma7() {
        return suma7;
    }

    public void setSuma7(String suma7) {
        this.suma7 = suma7;
    }

    public String getSuma8() {
        return suma8;
    }

    public void setSuma8(String suma8) {
        this.suma8 = suma8;
    }

    public String getSuma9() {
        return suma9;
    }

    public void setSuma9(String suma9) {
        this.suma9 = suma9;
    }

    public String getSuma10() {
        return suma10;
    }

    public void setSuma10(String suma10) {
        this.suma10 = suma10;
    }

    public String getSuma11() {
        return suma11;
    }

    public void setSuma11(String suma11) {
        this.suma11 = suma11;
    }
    
    
    
    public void sumar(){
        int a_a = Integer.parseInt(T1_A_A);
        int a_h = Integer.parseInt(T1_A_H);
        
        int h1_a = Integer.parseInt(T1_H1_A);
        int h1_h = Integer.parseInt(T1_H1_H);
        
        int h3_a = Integer.parseInt(T1_H3_A);
        int h3_h = Integer.parseInt(T1_H3_H);
        
        int b_a = Integer.parseInt(T1_B_A);
        int b_h = Integer.parseInt(T1_B_H);
        
        int df_a = Integer.parseInt(T4_DF_A);
        int df_h1 = Integer.parseInt(T4_DF_H1);
        int df_h3 = Integer.parseInt(T4_DF_H3);
        int h1_df_b = Integer.parseInt(T4_DF_B);
        
        int PS_A_A = Integer.parseInt(T5_PS_A_A);
        int PS_A_H = Integer.parseInt(T5_PS_A_H);
        int PS_H1_A = Integer.parseInt(T5_PS_H1_A);
        int PS_H1_H = Integer.parseInt(T5_PS_H1_H);
        int PS_H3_A = Integer.parseInt(T5_PS_H3_A);
        int PS_H3_H = Integer.parseInt(T5_PS_H3_H);
        int PS_B_A = Integer.parseInt(T5_PS_B_A);
        int PS_B_H = Integer.parseInt(T5_PS_B_H);
        
        int V_PSV = Integer.parseInt(T6_V_PSV);
        int V_TRGB = Integer.parseInt(T6_V_TRGB);
        int V_VAF = Integer.parseInt(T6_V_VAF);
        int V_VAPS = Integer.parseInt(T6_V_VAPS);
        int V_VAP = Integer.parseInt(T6_V_VAP);
        
        int OA_TP_A = Integer.parseInt(T7_OA_TP_A);
        int OA_TP_H = Integer.parseInt(T7_OA_TP_H);
        //Sumatorias
        int sumaA = a_a + a_h;
        int sumaB = h1_a + h1_h;
        int sumaC = h3_a + h3_h;
        int sumaD = b_a + b_h;
        int sumaE = df_a + df_h1 + df_h3 + h1_df_b;
        int sumaF = PS_A_A + PS_A_H;
        int sumaG = PS_H1_A + PS_H1_H;
        int sumaH = PS_H3_A + PS_H3_H;
        int sumaI = PS_B_A + PS_B_H;
        int sumaJ = V_TRGB + V_PSV +  + V_VAF + V_VAPS + V_VAP;
        int sumaK = OA_TP_A + OA_TP_H;
        
        suma1 = String.valueOf(sumaA);
        setSuma1(suma1);
        suma2 = String.valueOf(sumaB);
        setSuma2(suma2);
        suma3 = String.valueOf(sumaC);
        setSuma3(suma3);
        suma4 = String.valueOf(sumaD);
        setSuma4(suma4);
        suma5 = String.valueOf(sumaE);
        setSuma5(suma5);
        suma6 = String.valueOf(sumaF);
        setSuma6(suma6);
        suma7 = String.valueOf(sumaG);
        setSuma7(suma7);
        suma8 = String.valueOf(sumaH);
        setSuma8(suma8);
        suma9 = String.valueOf(sumaI);
        setSuma9(suma9);
        suma10 = String.valueOf(sumaJ);
        setSuma10(suma10);
        suma11 = String.valueOf(sumaK);
        setSuma11(suma11);
    }
}
