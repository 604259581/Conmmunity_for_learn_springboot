package com.community.demo.dto;

public class AcessTokenDTO {
    private String client_id;
    private String client_secrect;
    private String code;
    private String redirect_uri;
    private String state;
    public AcessTokenDTO(){}
    public AcessTokenDTO(String client_id,String client_secrect,String code,String redirect_uri,String state){
        this.client_id=client_id;
        this.client_secrect=client_secrect;
        this.code=code;
        this.redirect_uri=redirect_uri;
        this.state=state;
    }
    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getClient_secrect() {
        return client_secrect;
    }

    public void setClient_secrect(String client_secrect) {
        this.client_secrect = client_secrect;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRedirect_uri() {
        return redirect_uri;
    }

    public void setRedirect_uri(String redirect_uri) {
        this.redirect_uri = redirect_uri;
    }

    public String getState( ) {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
