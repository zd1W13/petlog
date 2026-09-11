package com.example.app.service;

import org.springframework.stereotype.Service;

@Service
public class FeedingCalculationService {

    // 1日の必要カロリーを計算する
    public double calculateDailyCalories(
            double weight,
            String species,
            String activityLevel,
            boolean neutered) {

        // RER（安静時エネルギー要求量）を計算する
        double rer = 70 * Math.pow(weight, 0.75);

        // ペットの種類・活動量・避妊去勢の有無によって係数を決める
        double factor;

        // 犬の場合
        if ("犬".equals(species)) {

            // 避妊・去勢済みの場合
            if (neutered) {

                if ("少ない".equals(activityLevel)) {
                    factor = 1.4;

                } else if ("多い".equals(activityLevel)) {
                    factor = 1.8;

                } else {
                    // 活動量「普通」
                    factor = 1.6;
                }

            // 避妊・去勢していない場合
            } else {

                if ("少ない".equals(activityLevel)) {
                    factor = 1.6;

                } else if ("多い".equals(activityLevel)) {
                    factor = 2.0;

                } else {
                    // 活動量「普通」
                    factor = 1.8;
                }
            }

        // 猫の場合
        } else if ("猫".equals(species)) {

            // 避妊・去勢済みの場合
            if (neutered) {

                if ("少ない".equals(activityLevel)) {
                    factor = 1.0;

                } else if ("多い".equals(activityLevel)) {
                    factor = 1.4;

                } else {
                    // 活動量「普通」
                    factor = 1.2;
                }

            // 避妊・去勢していない場合
            } else {

                if ("少ない".equals(activityLevel)) {
                    factor = 1.2;

                } else if ("多い".equals(activityLevel)) {
                    factor = 1.6;

                } else {
                    // 活動量「普通」
                    factor = 1.4;
                }
            }

        // 犬・猫以外の場合
        } else {

            // 「その他」は給餌量の自動計算を行わない
            throw new IllegalArgumentException(
                    "犬・猫以外は給餌量の自動計算に対応していません。");
        }

        // RER × 係数で1日の必要カロリーを求める
        return rer * factor;
    }

    // 1日の給餌量を計算する
    public double calculateFeedingAmount(
            double dailyCalories,
            int foodCalories) {

        // フードのカロリーは「100gあたり」なので100を掛ける
        return dailyCalories / foodCalories * 100;
    }
}