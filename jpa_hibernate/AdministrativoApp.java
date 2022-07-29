package demo;

import entities.Pessoa;
import entities.Produto;
import models.PessoaModel;
import models.ProdutoModel;

import java.time.LocalDate;
import java.util.List;

public class AdministrativoApp {

    public static void main(String[] args) {
        ProdutoModel produtoModel = new ProdutoModel();
        PessoaModel pessoaModel = new PessoaModel();

        // Teste ProdutoModel

        Produto produto1 = new Produto();
        produto1.setNome("TV");
        produto1.setPreco(300.0);
        produto1.setQuantidade(100);
        produto1.setStatus(true);

        Produto produto2 = new Produto();
        produto2.setNome("Nintendo Switch");
        produto2.setPreco(2500.0);
        produto2.setQuantidade(100);
        produto2.setStatus(true);

        produtoModel.create(produto1);
        produtoModel.create(produto2);

        List<Produto> produtos = produtoModel.findAll();
        System.out.println("Qtde de produtos encontrados : " + produtos.size());

        Produto produto3 = produtoModel.findById(produto2);
        System.out.println(produto3.toString());
        produto1.setQuantidade(50);
        produtoModel.update(produto1);
        produto3 = produtoModel.findById(produto1);
        System.out.println(produto3.toString());
        produtoModel.delete(produto1);

        produtos = produtoModel.findAll();
        System.out.println("Qtde de produtos encontrados : " + produtos.size());


        // Teste PessoaModel

        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNome("Melissa");
        pessoa1.setEmail("mwong");
        pessoa1.setIdade(28);
        pessoa1.setCpf("12345678912");
        pessoa1.setDataNascimento(LocalDate.of(1994, 6, 13));

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setNome("Larissa");
        pessoa2.setEmail("lwong");
        pessoa2.setIdade(22);
        pessoa2.setCpf("12345678912");
        pessoa2.setDataNascimento(LocalDate.of(2000, 2, 9));

        pessoaModel.create(pessoa1);
        pessoaModel.create(pessoa2);

        List<Pessoa> pessoas = pessoaModel.findAll();
        System.out.println("Qtde de pessoas encontradas : " + pessoas.size());

        Pessoa pessoa3 = pessoaModel.findById(pessoa2);
        System.out.println(pessoa3.toString());
        pessoa1.setEmail("mlewartoski");
        pessoaModel.update(pessoa1);
        pessoa3 = pessoaModel.findById(pessoa1);
        System.out.println(pessoa3.toString());
        pessoaModel.delete(pessoa1);

        pessoas = pessoaModel.findAll();
        System.out.println("Qtde de produtos encontrados : " + pessoas.size());

    }
}
