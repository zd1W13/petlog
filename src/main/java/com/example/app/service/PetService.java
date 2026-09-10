package com.example.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.app.domain.Pet;
import com.example.app.mapper.PetMapper;

@Service
public class PetService {

    // PetMapperを使えるようにする
    private final PetMapper petMapper;

    // コンストラクタでPetMapperを受け取る
    public PetService(PetMapper petMapper) {
        this.petMapper = petMapper;
    }

    // ペット一覧を取得する
    public List<Pet> getPetList() {
        return petMapper.selectAll();
    }

    // 指定したIDのペット情報を取得する
    public Pet getPetById(Integer id) {
        return petMapper.selectById(id);
    }

    // ペット情報を登録する
    public void addPet(Pet pet) {
        petMapper.insert(pet);
    }

    // ペット情報を更新する
    public void updatePet(Pet pet) {
        petMapper.update(pet);
    }

    // ペット情報を削除する
    public void deletePet(Integer id) {
        petMapper.delete(id);
    }
}