package br.com.cwi.api.controller;


import br.com.cwi.api.controller.request.IdRequest;
import br.com.cwi.api.controller.request.EditarPerfilUsuarioRequest;
import br.com.cwi.api.controller.request.IncluirComentarioRequest;
import br.com.cwi.api.controller.request.IncluirPublicacaoRequest;
import br.com.cwi.api.controller.response.ListarComentariosResponse;
import br.com.cwi.api.controller.response.ListarPublicacoesResponse;
import br.com.cwi.api.controller.response.UsuarioDetalharResponse;
import br.com.cwi.api.controller.response.UsuarioListaResponse;
import br.com.cwi.api.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UsuarioController {

    @Autowired
    EditarPerfilusuarioService editarPerfilusuarioService;

    @Autowired
    DetalharPerfilUsuarioService detalharPerfilUsuarioService;

    @Autowired
    ListarSolicitacoesService listarSolicitacoesService;

    @Autowired
    AceitarSolicitacaoAmizade aceitarSolicitacaoAmizade;

    @Autowired
    ListarUsuariosService listarUsuariosService;

    @Autowired
    EnviarSolicitacaoAmizadeService enviarSolicitacaoService;

    @Autowired
    IgnorarSolicitacaoService ignorarSolicitacaoService;

    @Autowired
    ListarAmigosService listarAmigosService;

    @Autowired
    VerificarAmizadeSolicitacaoService verificarAmizadeSolicitacaoService;

    @Autowired
    PublicarService publicarService;

    @Autowired
    ListarPublicacoes listarPublicacoes;

    @Autowired
    DesfazerAmizade desfazerAmizade;

    @Autowired
    CurtirPostagem curtirPostagem;

    @Autowired
    PrivarPostagemService privarPostagemService;

    @Autowired
    ComentarPublicacaoService comentarPublicacaoService;


    @Autowired
    ListarPublicacoesPerfilService listarPublicacoesPerfilService;

    @Autowired
    ListarComentariosPublicacaoService listarComentariosPublicacaoService;

    @Autowired
    RemoverComentarioService removerComentarioService;

    @Autowired
    RemoverPublicacaoService removerPublicacaoService;


    @PutMapping("/profile")
    public void editar(@Valid @RequestBody EditarPerfilUsuarioRequest request){
        editarPerfilusuarioService.editar(request);
    }

    @GetMapping("/{id}")
    public UsuarioDetalharResponse detalhar(@PathVariable Long id){
        return detalharPerfilUsuarioService.detalhar(id);
    }

    @GetMapping("/{id}/solicitacoes")
    public Page<UsuarioListaResponse> listarSolicitacoes(@PathVariable Long id, Pageable pageable){
        return listarSolicitacoesService.listar(id, pageable);
    }

    @PutMapping("/publicacoes/{id}/curtir")
    public void curtir(@PathVariable Long id, @RequestBody IdRequest request){
        curtirPostagem.curtir(id, request);
    }

    @PutMapping("/publicacoes/{id}/privar")
    public void privar(@PathVariable Long id){
        privarPostagemService.privar(id);
    }

    @PutMapping("/{id}/solicitacoes/enviar")
    public void enviarSolicitacao(@PathVariable Long id, @RequestBody IdRequest request) {
        enviarSolicitacaoService.enviar(id, request);
    }

    @PostMapping("/{id}/publicacoes/perfil")
    public Page<ListarPublicacoesResponse> listarPublicacoesPerfil(@PathVariable Long id, @RequestBody IdRequest request, Pageable pageable){
        return listarPublicacoesPerfilService.listar(id, request, pageable);
    }

    @PutMapping("/{id}/solicitacoes/aceitar")
    public void aceitar(@PathVariable Long id, @RequestBody IdRequest request){
        aceitarSolicitacaoAmizade.aceitar(id, request);
    }

    @PostMapping("/publicacao/{id}/comentar")
    public void comentar(@PathVariable Long id, @RequestBody IncluirComentarioRequest request){
        comentarPublicacaoService.comentar(id, request);
    }

    @GetMapping("/publicacao/{id}/comentar")
    public Page<ListarComentariosResponse> listaComentarios(@PathVariable Long id, Pageable pageable){
        return listarComentariosPublicacaoService.listar(id , pageable);
    }

    @DeleteMapping("/publicacao/comentar/{id}")
    public void removerComentario(@PathVariable Long id){
        removerComentarioService.remover(id);
    }


    @PostMapping("/{id}/publicacao")
    public void publicar(@PathVariable Long id, @Valid @RequestBody IncluirPublicacaoRequest request){
        publicarService.publicar(id, request);
    }

    @DeleteMapping("/publicacao/{id}")
    public void deletarPublicacao(@PathVariable Long id){
        removerPublicacaoService.deletar(id);
    }

    @GetMapping("/{id}/publicacao")
    public Page<ListarPublicacoesResponse> listarHome(@PathVariable Long id, Pageable pageable){
        return listarPublicacoes.listar(id, pageable);
    }


    @GetMapping("/{id}/amigos")
    public Page<UsuarioListaResponse> listarAmigos(@RequestParam("nome") String nome, @PathVariable Long id, Pageable pageable){
        return listarAmigosService.listar(id, nome, pageable);
    }

    @PutMapping("/{id}/amigos/desfazer")
    public void desfazerAmizade(@PathVariable Long id, @Valid @RequestBody IdRequest request){
        desfazerAmizade.desfazer(id, request);
    }

    @PostMapping("/{id}/verificar")
    public Integer verificarAmigosSolicitacoes(@PathVariable Long id, @Valid @RequestBody IdRequest request){
        return verificarAmizadeSolicitacaoService.verificar(id, request);
    }

    @PutMapping("/{id}/solicitacoes/ignorar")
    public void ignorar(@PathVariable Long id, @Valid @RequestBody IdRequest request){
        ignorarSolicitacaoService.ignorar(id, request);
    }

    @GetMapping("/{id}/search")
    public Page<UsuarioListaResponse> listarUsuarios(@RequestParam("nome") String nome, Pageable pageable, @PathVariable Long id){
        return listarUsuariosService.listar(nome, pageable, id);
    }

}
