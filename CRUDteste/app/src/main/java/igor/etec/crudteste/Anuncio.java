package igor.etec.crudteste;

public class Anuncio {
    private int id;
    private String nome;
    private String assunto;
    private String mensagem;

    public Anuncio(){}

    public Anuncio(int id, String nome, String assunto, String mensagem){
        this.id = id;
        this.assunto = assunto;
        this.mensagem = mensagem;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String toString() {
        return ""+ id +
                "\nnome=" + nome + "\n" +
                "assunto=" + assunto + "\n" +
                "mensagem=" + mensagem + "\n";
    }
}
