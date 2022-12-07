package polyakov.nametranscriptor.model.rulesets;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class RussianTest {

    @Test
    void transcribe() {
        String text = "AabBdD eEfF gGiI Kk hHlL MmNnoOpP RrSstTuU vVyYxXzZ Schennikov Borshchevoi Keldysh Shakhiya " +
                "Chechnya rodnya Babayevski Yagaylo Aypetri yula Yuretsky Uygurets rayonniy Gor'ky yogurt Zhokhina " +
                "Komsomol'skoye Bokii tikhy pologiy igor Olga Iaroslav Yuriev Yuri Kolomyts Yulia Zapotichnaya " +
                "Elvira Ziyastinova Sadzhaya Shamsiddin Shanbiev Breytveyt Besserdechnaya Tsvilikhovski Fazyax " +
                "Chayandyar";
        String transcription = "АабБдД эЕфФ гГиИ Кк хХлЛ МмНноОпП РрСстТуУ вВыЙксКсзЗ Щенников Борщевой Келдыш Шахия " +
                "Чечня родня Бабаевский Ягайло Айпетри юла Юрецкий Уйгурец районный Горький йогурт Жохина " +
                "Комсомольское Бокий тихий пологий Игорь Ольга Ярослав Юриев Юрий Коломыц Юлия Запотичная Эльвира " +
                "Зиястинова Саджая Шамсиддин Шанбиев Брейтвейт Бессердечная Цвилиховский Фазякс Чаяндяр";
        Russian service = new Russian();

        String[] words = text.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String w : words) {
            sb.append(service.transcribe(w, 0)).append(" ");
        }
        String result = sb.toString().trim();
        assertNotNull(sb);
        assertEquals(transcription, result);
    }
}