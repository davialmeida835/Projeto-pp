package Model;

public class TipoRoupaPadrao implements TipoRoupa{

	private final String descricao;
    private final int preco;

    public TipoRoupaPadrao(String descricao, int preco) {
        this.descricao = descricao;
        this.preco = preco;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    @Override
    public int getPreco() {
        return preco;
    }


}
