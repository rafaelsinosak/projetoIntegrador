package br.gov.sp.fatec.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Aluno;
import br.gov.sp.fatec.model.Disciplina;
import br.gov.sp.fatec.model.Presenca;
import br.gov.sp.fatec.repository.PresencaRepository;

@Service("presencaService")
public class PresencaServiceImpl implements PresencaService {
	
	@Autowired
	private PresencaRepository presencaRepo;

	public Presenca buscar(Long id) {
		// TODO Auto-generated method stub
		return presencaRepo.findById(id);
	}

	public List<Presenca> buscarTodos(Long disciplina, Date data) {
		// TODO Auto-generated method stub
		return presencaRepo.findAll(disciplina, data);
	}

	@Transactional
	public Presenca salvar(Presenca presenca) {
		return presencaRepo.save(presenca);

	}

	public List<Aluno> buscarPorDisciplina(Long id) {
		// TODO Auto-generated method stub
		return presencaRepo.findAlunosByDisciplina(id);
	}

	public List<Disciplina> buscarDisciplinaPorAluno(Long idAluno) {
		// TODO Auto-generated method stub
		return presencaRepo.findAllDisciplinaByAluno(idAluno);
	}

	public Long qtdePresencaFalta(Long idAluno, Long idDisciplina, boolean presenca) {
		// TODO Auto-generated method stub
		return presencaRepo.countPresencasFaltas(idAluno, idDisciplina, presenca);
	}

}
