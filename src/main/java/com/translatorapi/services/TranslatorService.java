package com.translatorapi.services;

import com.translatorapi.domain.entities.Translation;
import com.translatorapi.dtos.TranslatorDTO;
import net.suuft.libretranslate.Translator;
import org.springframework.stereotype.Service;

@Service
public class TranslatorService {

  public Translation translate(TranslatorDTO data) {
    return new Translation(Translator.translate(data.lang_from(), data.lang_to(), data.text()));
  }
}
