package com.produtos.apirest.resources;

import java.util.List;
import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Produtos")
@CrossOrigin(origins = "*")
public class ProdutoResource {

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("/produtos")
    @ApiOperation(value = "Retorna lista de Produtos")
    public List<Produto> listaProdutos() {
        return produtoRepository.findAll();
    }

    @GetMapping("/produtos/{id}")
    @ApiOperation(value = "Retorna produto pelo id")
    public Produto getById(@PathVariable(value = "id") long id) {
        return produtoRepository.findById(id);
    }

    @PostMapping("/produtos")
    @ApiOperation(value = "Realiza o inser de produto")
    public Produto create(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }
    
    @DeleteMapping("/produtos")
    @ApiOperation(value = "Deleta um produto")
    public void delete(@RequestBody Produto produto) {
        produtoRepository.delete(produto);
    }

    @PutMapping("produtos/{id}")
    @ApiOperation(value = "Altera um produto")
    public Produto putMethodName(@PathVariable String id, @RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }
}