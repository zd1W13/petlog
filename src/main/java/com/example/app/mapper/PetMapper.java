package com.example.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.Pet;

@Mapper
public interface PetMapper {

	// 全ペットの一覧を取得する
    public List<Pet> selectAll();

    // 指定したIDのペットを1件取得する
    public Pet selectById(Integer id);

    // ペット情報を登録する
    public void insert(Pet pet);

    // ペット情報を更新する
    public void update(Pet pet);

    // 指定したIDのペット情報を削除する
    public void delete(Integer id);
}
