package com.example.app.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.app.domain.HealthRecord;
import com.example.app.mapper.HealthRecordMapper;

@Service
public class HealthRecordService {

    // 健康記録のDB操作を行うMapper
    private final HealthRecordMapper healthRecordMapper;

    // HealthRecordMapperを使えるようにする
    public HealthRecordService(HealthRecordMapper healthRecordMapper) {
        this.healthRecordMapper = healthRecordMapper;
    }

    // 指定したペットの健康記録をすべて取得する
    public List<HealthRecord> getHealthRecordList(Integer petId) {
        return healthRecordMapper.selectByPetId(petId);
    }
    
 // 指定したペットの直近1か月の健康記録を取得する
    public List<HealthRecord> getLastMonthHealthRecords(Integer petId) {
    	return healthRecordMapper.selectLastMonthByPetId(petId);
    }

    // 指定したIDの健康記録を1件取得する
    public HealthRecord getHealthRecordById(Integer id) {
        return healthRecordMapper.selectById(id);
    }

    // 指定したペット・日付の健康記録を1件取得する
    public HealthRecord getHealthRecordByDate(
            Integer petId,
            LocalDate recordDate) {

        return healthRecordMapper.selectByPetIdAndDate(
                petId,
                recordDate);
    }

    // 健康記録を新しく登録する
    public void addHealthRecord(HealthRecord healthRecord) {
        healthRecordMapper.insert(healthRecord);
    }

    // 健康記録を更新する
    public void updateHealthRecord(HealthRecord healthRecord) {
        healthRecordMapper.update(healthRecord);
    }

    // 健康記録を削除する
    public void deleteHealthRecord(Integer id) {
        healthRecordMapper.delete(id);
    }
}
