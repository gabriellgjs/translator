package com.translatorapi.dtos;

import net.suuft.libretranslate.Language;
import jakarta.validation.constraints.NotBlank;

public record TranslatorDTO(
  Language lang_from,

  Language lang_to,

  @NotBlank(message = "Texto para ser traduzido não foi informado")
  String text

  ) {}
