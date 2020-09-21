package br.edu.uepb;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class AlunoRepository  {


    // simulando nossa base de dados
    private static HashMap<Integer, Aluno> alunos = new HashMap<>();
    Aluno aluno = new Aluno();

    // métodos para manipular
    public List<Aluno> getAll() {
        return new ArrayList<>(alunos.values());
    }

    public void create(Aluno p) {
        if (p.getId() == 0)
            p.setId(generateId(alunos.size() + 1));
        alunos.put(aluno.getId(), p);
    }

    private int generateId(final int possible) {
        if (alunos.containsKey(possible))
            return generateId(possible + 1);
        return possible;
    }

    public Aluno getById(int id) {
        return alunos.get(id);
    }

    public void edit(Aluno p) {
        alunos.remove(p.getId());
        alunos.put(p.getId(), p);
    }

    public void delete(int id) {
        alunos.remove(id);
    }
}