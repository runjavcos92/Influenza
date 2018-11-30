/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.inject.Inject;


/**
 *
 * @author FRANCISCONAVA
 */
@Named(value = "registroDatosDTO")
@SessionScoped
public class RegistroDatosDTO implements Serializable {

    /**
     * Creates a new instance of RegistroDatosDTO
     */
    public RegistroDatosDTO() {
    }
    
    @Inject
    private usuarioDTO usuario;
    private String  id_log_influ;
    private String  T1_A_A_1;
    private String  T1_A_H_1;
    private String  T1_H1_A_1;
    private String  T1_H1_H_1;
    private String  T1_H3_A_1;
    private String  T1_H3_H_1;
    private String  T1_B_A_1;
    private String  T1_B_H_1;
    private String  T2_24_2;
    private String  T2_H_M_2;
    private String  T2_I_M_2;
    private String  T2_C_UTI_2;
    private String  T2_C_U_2;
    private String  T3_DF_NA_3;
    private String  T3_DF_PCR_3;
    private String  T4_DF_A_4;
    private String  T4_DF_H1_4;
    private String  T4_DF_H3_4;
    private String  T4_DF_B_4;
    private String  T5_PS_A_A_5;
    private String  T5_PS_A_H_5;
    private String  T5_PS_H1_A_5;
    private String  T5_PS_H1_H_5;
    private String  T5_PS_H3_A_5;
    private String  T5_PS_H3_H_5;
    private String  T5_PS_B_A_5;
    private String  T5_PS_B_H_5;
    private String  T6_V_TRGB_6;
    private String  T6_V_VAPS_6;
    private String  T6_V_PSV_6;
    private String  T6_V_VAP_6;
    private String  T6_V_VAF_6;
    private String  T7_OA_TP_A_7;
    private String  T7_OA_TP_H_7;
    private String  T7_OA_EI_A_7;
    private String  FECHA;
    private String  tot_1_1;
    private String  tot_1_2;
    private String  tot_1_3;
    private String  tot_1_4;
    private String  tot_1_5;
    private String  tot_2_1;
    private String  tot_2_2;

    public usuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(usuarioDTO usuario) {
        this.usuario = usuario;
    }

    public String getId_log_influ() {
        return id_log_influ;
    }

    public void setId_log_influ(String id_log_influ) {
        this.id_log_influ = id_log_influ;
    }

    public String getT1_A_A_1() {
        return T1_A_A_1;
    }

    public void setT1_A_A_1(String T1_A_A_1) {
        this.T1_A_A_1 = T1_A_A_1;
    }

    public String getT1_A_H_1() {
        return T1_A_H_1;
    }

    public void setT1_A_H_1(String T1_A_H_1) {
        this.T1_A_H_1 = T1_A_H_1;
    }

    public String getT1_H1_A_1() {
        return T1_H1_A_1;
    }

    public void setT1_H1_A_1(String T1_H1_A_1) {
        this.T1_H1_A_1 = T1_H1_A_1;
    }

    public String getT1_H1_H_1() {
        return T1_H1_H_1;
    }

    public void setT1_H1_H_1(String T1_H1_H_1) {
        this.T1_H1_H_1 = T1_H1_H_1;
    }

    public String getT1_H3_A_1() {
        return T1_H3_A_1;
    }

    public void setT1_H3_A_1(String T1_H3_A_1) {
        this.T1_H3_A_1 = T1_H3_A_1;
    }

    public String getT1_H3_H_1() {
        return T1_H3_H_1;
    }

    public void setT1_H3_H_1(String T1_H3_H_1) {
        this.T1_H3_H_1 = T1_H3_H_1;
    }

    public String getT1_B_A_1() {
        return T1_B_A_1;
    }

    public void setT1_B_A_1(String T1_B_A_1) {
        this.T1_B_A_1 = T1_B_A_1;
    }

    public String getT1_B_H_1() {
        return T1_B_H_1;
    }

    public void setT1_B_H_1(String T1_B_H_1) {
        this.T1_B_H_1 = T1_B_H_1;
    }

    public String getT2_24_2() {
        return T2_24_2;
    }

    public void setT2_24_2(String T2_24_2) {
        this.T2_24_2 = T2_24_2;
    }

    public String getT2_H_M_2() {
        return T2_H_M_2;
    }

    public void setT2_H_M_2(String T2_H_M_2) {
        this.T2_H_M_2 = T2_H_M_2;
    }

    public String getT2_I_M_2() {
        return T2_I_M_2;
    }

    public void setT2_I_M_2(String T2_I_M_2) {
        this.T2_I_M_2 = T2_I_M_2;
    }

    public String getT2_C_UTI_2() {
        return T2_C_UTI_2;
    }

    public void setT2_C_UTI_2(String T2_C_UTI_2) {
        this.T2_C_UTI_2 = T2_C_UTI_2;
    }

    public String getT2_C_U_2() {
        return T2_C_U_2;
    }

    public void setT2_C_U_2(String T2_C_U_2) {
        this.T2_C_U_2 = T2_C_U_2;
    }

    public String getT3_DF_NA_3() {
        return T3_DF_NA_3;
    }

    public void setT3_DF_NA_3(String T3_DF_NA_3) {
        this.T3_DF_NA_3 = T3_DF_NA_3;
    }

    public String getT3_DF_PCR_3() {
        return T3_DF_PCR_3;
    }

    public void setT3_DF_PCR_3(String T3_DF_PCR_3) {
        this.T3_DF_PCR_3 = T3_DF_PCR_3;
    }

    public String getT4_DF_A_4() {
        return T4_DF_A_4;
    }

    public void setT4_DF_A_4(String T4_DF_A_4) {
        this.T4_DF_A_4 = T4_DF_A_4;
    }

    public String getT4_DF_H1_4() {
        return T4_DF_H1_4;
    }

    public void setT4_DF_H1_4(String T4_DF_H1_4) {
        this.T4_DF_H1_4 = T4_DF_H1_4;
    }

    public String getT4_DF_H3_4() {
        return T4_DF_H3_4;
    }

    public void setT4_DF_H3_4(String T4_DF_H3_4) {
        this.T4_DF_H3_4 = T4_DF_H3_4;
    }

    public String getT4_DF_B_4() {
        return T4_DF_B_4;
    }

    public void setT4_DF_B_4(String T4_DF_B_4) {
        this.T4_DF_B_4 = T4_DF_B_4;
    }

    public String getT5_PS_A_A_5() {
        return T5_PS_A_A_5;
    }

    public void setT5_PS_A_A_5(String T5_PS_A_A_5) {
        this.T5_PS_A_A_5 = T5_PS_A_A_5;
    }

    public String getT5_PS_A_H_5() {
        return T5_PS_A_H_5;
    }

    public void setT5_PS_A_H_5(String T5_PS_A_H_5) {
        this.T5_PS_A_H_5 = T5_PS_A_H_5;
    }

    public String getT5_PS_H1_A_5() {
        return T5_PS_H1_A_5;
    }

    public void setT5_PS_H1_A_5(String T5_PS_H1_A_5) {
        this.T5_PS_H1_A_5 = T5_PS_H1_A_5;
    }

    public String getT5_PS_H1_H_5() {
        return T5_PS_H1_H_5;
    }

    public void setT5_PS_H1_H_5(String T5_PS_H1_H_5) {
        this.T5_PS_H1_H_5 = T5_PS_H1_H_5;
    }

    public String getT5_PS_H3_A_5() {
        return T5_PS_H3_A_5;
    }

    public void setT5_PS_H3_A_5(String T5_PS_H3_A_5) {
        this.T5_PS_H3_A_5 = T5_PS_H3_A_5;
    }

    public String getT5_PS_H3_H_5() {
        return T5_PS_H3_H_5;
    }

    public void setT5_PS_H3_H_5(String T5_PS_H3_H_5) {
        this.T5_PS_H3_H_5 = T5_PS_H3_H_5;
    }

    public String getT5_PS_B_A_5() {
        return T5_PS_B_A_5;
    }

    public void setT5_PS_B_A_5(String T5_PS_B_A_5) {
        this.T5_PS_B_A_5 = T5_PS_B_A_5;
    }

    public String getT5_PS_B_H_5() {
        return T5_PS_B_H_5;
    }

    public void setT5_PS_B_H_5(String T5_PS_B_H_5) {
        this.T5_PS_B_H_5 = T5_PS_B_H_5;
    }

    public String getT6_V_TRGB_6() {
        return T6_V_TRGB_6;
    }

    public void setT6_V_TRGB_6(String T6_V_TRGB_6) {
        this.T6_V_TRGB_6 = T6_V_TRGB_6;
    }

    public String getT6_V_VAPS_6() {
        return T6_V_VAPS_6;
    }

    public void setT6_V_VAPS_6(String T6_V_VAPS_6) {
        this.T6_V_VAPS_6 = T6_V_VAPS_6;
    }

    public String getT6_V_PSV_6() {
        return T6_V_PSV_6;
    }

    public void setT6_V_PSV_6(String T6_V_PSV_6) {
        this.T6_V_PSV_6 = T6_V_PSV_6;
    }

    public String getT6_V_VAP_6() {
        return T6_V_VAP_6;
    }

    public void setT6_V_VAP_6(String T6_V_VAP_6) {
        this.T6_V_VAP_6 = T6_V_VAP_6;
    }

    public String getT6_V_VAF_6() {
        return T6_V_VAF_6;
    }

    public void setT6_V_VAF_6(String T6_V_VAF_6) {
        this.T6_V_VAF_6 = T6_V_VAF_6;
    }

    public String getT7_OA_TP_A_7() {
        return T7_OA_TP_A_7;
    }

    public void setT7_OA_TP_A_7(String T7_OA_TP_A_7) {
        this.T7_OA_TP_A_7 = T7_OA_TP_A_7;
    }

    public String getT7_OA_TP_H_7() {
        return T7_OA_TP_H_7;
    }

    public void setT7_OA_TP_H_7(String T7_OA_TP_H_7) {
        this.T7_OA_TP_H_7 = T7_OA_TP_H_7;
    }

    public String getT7_OA_EI_A_7() {
        return T7_OA_EI_A_7;
    }

    public void setT7_OA_EI_A_7(String T7_OA_EI_A_7) {
        this.T7_OA_EI_A_7 = T7_OA_EI_A_7;
    }

    public String getFECHA() {
        return FECHA;
    }

    public void setFECHA(String FECHA) {
        this.FECHA = FECHA;
    }

    public String getTot_1_1() {
        return tot_1_1;
    }

    public void setTot_1_1(String tot_1_1) {
        this.tot_1_1 = tot_1_1;
    }

    public String getTot_1_2() {
        return tot_1_2;
    }

    public void setTot_1_2(String tot_1_2) {
        this.tot_1_2 = tot_1_2;
    }

    public String getTot_1_3() {
        return tot_1_3;
    }

    public void setTot_1_3(String tot_1_3) {
        this.tot_1_3 = tot_1_3;
    }

    public String getTot_1_4() {
        return tot_1_4;
    }

    public void setTot_1_4(String tot_1_4) {
        this.tot_1_4 = tot_1_4;
    }

    public String getTot_1_5() {
        return tot_1_5;
    }

    public void setTot_1_5(String tot_1_5) {
        this.tot_1_5 = tot_1_5;
    }

    public String getTot_2_1() {
        return tot_2_1;
    }

    public void setTot_2_1(String tot_2_1) {
        this.tot_2_1 = tot_2_1;
    }

    public String getTot_2_2() {
        return tot_2_2;
    }

    public void setTot_2_2(String tot_2_2) {
        this.tot_2_2 = tot_2_2;
    }
    
    
    
}
