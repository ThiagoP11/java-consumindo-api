package br.com.alura.screenmatch.modelos;

public class Login {

    private String login;
    private String id;
    private String htmlUrl;

    public Login(UsuarioGitHub usuarioGitHub){
        this.login = usuarioGitHub.login();
        this.id = usuarioGitHub.id();
        this.htmlUrl = usuarioGitHub.htmlLogin();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
