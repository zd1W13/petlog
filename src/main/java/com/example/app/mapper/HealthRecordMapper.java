package com.example.app.mapper;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.app.domain.HealthRecord;

@Mapper
public interface HealthRecordMapper {

	// 指定したペットの健康記録をすべて取得する
	public List<HealthRecord> selectByPetId(Integer petId);

	// 指定したペットの直近1か月の健康記録を取得する
	public List<HealthRecord> selectLastMonthByPetId(Integer petId);

	// 指定した健康記録をIDで1件取得する
	public HealthRecord selectById(Integer id);

	// 指定したペット・日付の健康記録を1件取得する
	// カレンダーで日付を選択したときにも使用する
	public HealthRecord selectByPetIdAndDate(
			@Param("petId") Integer petId,
			@Param("recordDate") LocalDate recordDate);

	// 健康記録を新しく登録する
	public void insert(HealthRecord healthRecord);

	// 健康記録を更新する
	public void update(HealthRecord healthRecord);

	// 指定した健康記録を削除する
	public void delete(Integer id);

}