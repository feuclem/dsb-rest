package com.dsb.rest.model

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.function.Predicate

@JsonIgnoreProperties(ignoreUnknown = true)
class Statistic {

    companion object {
        class MapperPredicateStat(var label: String, var predicate: Predicate<Statistic>)

        fun getPredicateByLabel(label: String): Predicate<Statistic> {
            return listOf(
                MapperPredicateStat("Vitalite") { obj: Statistic -> obj.hasVitalite() },
                MapperPredicateStat("Force") { obj: Statistic -> obj.hasForce() },
                MapperPredicateStat("Intelligence") { obj: Statistic -> obj.hasIntelligence() },
                MapperPredicateStat("Chance") { obj: Statistic -> obj.hasChance() },
                MapperPredicateStat("Agilite") { obj: Statistic -> obj.hasAgilite() },
                MapperPredicateStat("PA") { obj: Statistic -> obj.hasPA() },
                MapperPredicateStat("PM") { obj: Statistic -> obj.hasPM() },
                MapperPredicateStat("PO") { obj: Statistic -> obj.hasPO() },
                MapperPredicateStat("Critique") { obj: Statistic -> obj.hasCritique() },
                MapperPredicateStat("Puissance") { obj: Statistic -> obj.hasPuissance() }
            ).first { mapperPredicateStat: MapperPredicateStat -> mapperPredicateStat.label == label }.predicate
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Vitalité")
    var vitalite: FromTo? = null

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("PA")
    var pa: FromTo? = null

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("PM")
    var pm: FromTo? = null

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Portée")
    var po: FromTo? = null

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Sagesse")
    var sagesse: FromTo? = null

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Soins")
    var soins: FromTo? = null

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonAlias(
        "% Critique",
        "1% Critique",
        "2% Critique",
        "3% Critique",
        "4% Critique",
        "5% Critique",
        "6% Critique",
        "7% Critique",
        "8% Critique",
        "9% Critique",
        "10% Critique",
        "11% Critique",
        "12% Critique",
        "13% Critique",
        "14% Critique",
        "15% Critique",
        "16% Critique",
        "17% Critique",
        "18% Critique",
        "19% Critique",
        "20% Critique",
        "-1% Critique",
        "-2% Critique",
        "-3% Critique",
        "-4% Critique",
        "-5% Critique",
        "-6% Critique",
        "-7% Critique",
        "-8% Critique",
        "-9% Critique",
        "-10% Critique",
        "-11% Critique",
        "-12% Critique",
        "-13% Critique",
        "-14% Critique",
        "-15% Critique",
        "-16% Critique",
        "-17% Critique",
        "-18% Critique",
        "-19% Critique",
        "-20% Critique"
    )
    var critique: FromTo? = null

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Puissance")
    var puissance: FromTo? = null

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Force")
    var force: FromTo? = null

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Intelligence")
    var intelligence: FromTo? = null

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Chance")
    var chance: FromTo? = null

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Agilité")
    var agilite: FromTo? = null

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Initiative")
    var initiative: FromTo? = null

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Dommages Neutre")
    var dommagesNeutre: FromTo? = null

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Dommages Terre")
    var dommagesTerre: FromTo? = null

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Dommages Feu")
    var dommagesFeu: FromTo? = null

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Dommages Eau")
    var dommagesEau: FromTo? = null

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Dommages Air")
    var dommagesAir: FromTo? = null

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Dommages")
    var dommages: FromTo? = null

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("(dommages Neutre)")
    var dommagesArmeNeutre: FromTo? = null

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("(dommages Terre)")
    var dommagesArmeTerre: FromTo? = null

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("(dommages Feu)")
    var dommagesArmeFeu: FromTo? = null

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("(dommages Eau)")
    var dommagesArmeEau: FromTo? = null

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Dommages Critiques")
    var dommagesCritiques: FromTo? = null

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Dommages Poussée")
    var dommagesPoussee: FromTo? = null

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonAlias(
        "% Résistance Neutre",
        "1% Résistance Neutre",
        "2% Résistance Neutre",
        "3% Résistance Neutre",
        "4% Résistance Neutre",
        "5% Résistance Neutre",
        "6% Résistance Neutre",
        "7% Résistance Neutre",
        "8% Résistance Neutre",
        "9% Résistance Neutre",
        "10% Résistance Neutre",
        "11% Résistance Neutre",
        "12% Résistance Neutre",
        "13% Résistance Neutre",
        "14% Résistance Neutre",
        "15% Résistance Neutre",
        "16% Résistance Neutre",
        "17% Résistance Neutre",
        "18% Résistance Neutre",
        "19% Résistance Neutre",
        "20% Résistance Neutre",
        "-1% Résistance Neutre",
        "-2% Résistance Neutre",
        "-3% Résistance Neutre",
        "-4% Résistance Neutre",
        "-5% Résistance Neutre",
        "-6% Résistance Neutre",
        "-7% Résistance Neutre",
        "-8% Résistance Neutre",
        "-9% Résistance Neutre",
        "-10% Résistance Neutre",
        "-11% Résistance Neutre",
        "-12% Résistance Neutre",
        "-13% Résistance Neutre",
        "-14% Résistance Neutre",
        "-15% Résistance Neutre",
        "-16% Résistance Neutre",
        "-17% Résistance Neutre",
        "-18% Résistance Neutre",
        "-19% Résistance Neutre",
        "-20% Résistance Neutre"
    )
    var pourcentResistanceNeutre: FromTo? = null

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonAlias(
        "% Résistance Terre",
        "1% Résistance Terre",
        "2% Résistance Terre",
        "3% Résistance Terre",
        "4% Résistance Terre",
        "5% Résistance Terre",
        "6% Résistance Terre",
        "7% Résistance Terre",
        "8% Résistance Terre",
        "9% Résistance Terre",
        "10% Résistance Terre",
        "11% Résistance Terre",
        "12% Résistance Terre",
        "13% Résistance Terre",
        "14% Résistance Terre",
        "15% Résistance Terre",
        "16% Résistance Terre",
        "17% Résistance Terre",
        "18% Résistance Terre",
        "19% Résistance Terre",
        "20% Résistance Terre",
        "-1% Résistance Terre",
        "-2% Résistance Terre",
        "-3% Résistance Terre",
        "-4% Résistance Terre",
        "-5% Résistance Terre",
        "-6% Résistance Terre",
        "-7% Résistance Terre",
        "-8% Résistance Terre",
        "-9% Résistance Terre",
        "-10% Résistance Terre",
        "-11% Résistance Terre",
        "-12% Résistance Terre",
        "-13% Résistance Terre",
        "-14% Résistance Terre",
        "-15% Résistance Terre",
        "-16% Résistance Terre",
        "-17% Résistance Terre",
        "-18% Résistance Terre",
        "-19% Résistance Terre",
        "-20% Résistance Terre"
    )
    var pourcentResistanceTerre: FromTo? = null

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonAlias(
        "% Résistance Feu",
        "1% Résistance Feu",
        "2% Résistance Feu",
        "3% Résistance Feu",
        "4% Résistance Feu",
        "5% Résistance Feu",
        "6% Résistance Feu",
        "7% Résistance Feu",
        "8% Résistance Feu",
        "9% Résistance Feu",
        "10% Résistance Feu",
        "11% Résistance Feu",
        "12% Résistance Feu",
        "13% Résistance Feu",
        "14% Résistance Feu",
        "15% Résistance Feu",
        "16% Résistance Feu",
        "17% Résistance Feu",
        "18% Résistance Feu",
        "19% Résistance Feu",
        "20% Résistance Feu",
        "-1% Résistance Feu",
        "-2% Résistance Feu",
        "-3% Résistance Feu",
        "-4% Résistance Feu",
        "-5% Résistance Feu",
        "-6% Résistance Feu",
        "-7% Résistance Feu",
        "-8% Résistance Feu",
        "-9% Résistance Feu",
        "-10% Résistance Feu",
        "-11% Résistance Feu",
        "-12% Résistance Feu",
        "-13% Résistance Feu",
        "-14% Résistance Feu",
        "-15% Résistance Feu",
        "-16% Résistance Feu",
        "-17% Résistance Feu",
        "-18% Résistance Feu",
        "-19% Résistance Feu",
        "-20% Résistance Feu"
    )
    var pourcentResistanceFeu: FromTo? = null

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonAlias(
        "% Résistance Eau",
        "1% Résistance Eau",
        "2% Résistance Eau",
        "3% Résistance Eau",
        "4% Résistance Eau",
        "5% Résistance Eau",
        "6% Résistance Eau",
        "7% Résistance Eau",
        "8% Résistance Eau",
        "9% Résistance Eau",
        "10% Résistance Eau",
        "11% Résistance Eau",
        "12% Résistance Eau",
        "13% Résistance Eau",
        "14% Résistance Eau",
        "15% Résistance Eau",
        "16% Résistance Eau",
        "17% Résistance Eau",
        "18% Résistance Eau",
        "19% Résistance Eau",
        "20% Résistance Eau",
        "-1% Résistance Eau",
        "-2% Résistance Eau",
        "-3% Résistance Eau",
        "-4% Résistance Eau",
        "-5% Résistance Eau",
        "-6% Résistance Eau",
        "-7% Résistance Eau",
        "-8% Résistance Eau",
        "-9% Résistance Eau",
        "-10% Résistance Eau",
        "-11% Résistance Eau",
        "-12% Résistance Eau",
        "-13% Résistance Eau",
        "-14% Résistance Eau",
        "-15% Résistance Eau",
        "-16% Résistance Eau",
        "-17% Résistance Eau",
        "-18% Résistance Eau",
        "-19% Résistance Eau",
        "-20% Résistance Eau"
    )
    var pourcentResistanceEau: FromTo? = null

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonAlias(
        "% Résistance Air",
        "1% Résistance Air",
        "2% Résistance Air",
        "3% Résistance Air",
        "4% Résistance Air",
        "5% Résistance Air",
        "6% Résistance Air",
        "7% Résistance Air",
        "8% Résistance Air",
        "9% Résistance Air",
        "10% Résistance Air",
        "11% Résistance Air",
        "12% Résistance Air",
        "13% Résistance Air",
        "14% Résistance Air",
        "15% Résistance Air",
        "16% Résistance Air",
        "17% Résistance Air",
        "18% Résistance Air",
        "19% Résistance Air",
        "20% Résistance Air",
        "-1% Résistance Air",
        "-2% Résistance Air",
        "-3% Résistance Air",
        "-4% Résistance Air",
        "-5% Résistance Air",
        "-6% Résistance Air",
        "-7% Résistance Air",
        "-8% Résistance Air",
        "-9% Résistance Air",
        "-10% Résistance Air",
        "-11% Résistance Air",
        "-12% Résistance Air",
        "-13% Résistance Air",
        "-14% Résistance Air",
        "-15% Résistance Air",
        "-16% Résistance Air",
        "-17% Résistance Air",
        "-18% Résistance Air",
        "-19% Résistance Air",
        "-20% Résistance Air"
    )
    var pourcentResistanceAir: FromTo? = null

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Résistance Critiques")
    var resistanceCritiques: FromTo? = null

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Résistance Poussée")
    var resistancePoussee: FromTo? = null

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Tacle")
    var tacle: FromTo? = null

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Fuite")
    var fuite: FromTo? = null

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Esquive PA")
    var esquivePa: FromTo? = null

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Esquive PM")
    var esquivePm: FromTo? = null

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Retrait PA")
    var retraitPa: FromTo? = null

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Retrait PM")
    var retraitPm: FromTo? = null

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonAlias(
        "Résistance Neutre",
        "2 Résistance Neutre",
        "3 Résistance Neutre",
        "4 Résistance Neutre",
        "5 Résistance Neutre",
        "6 Résistance Neutre",
        "7 Résistance Neutre",
        "8 Résistance Neutre",
        "9 Résistance Neutre",
        "10 Résistance Neutre",
        "11 Résistance Neutre",
        "12 Résistance Neutre",
        "13 Résistance Neutre",
        "14 Résistance Neutre",
        "15 Résistance Neutre",
        "16 Résistance Neutre",
        "17 Résistance Neutre",
        "18 Résistance Neutre",
        "19 Résistance Neutre",
        "20 Résistance Neutre",
        "40 Résistance Neutre",
        "-1 Résistance Neutre",
        "-2 Résistance Neutre",
        "-3 Résistance Neutre",
        "-4 Résistance Neutre",
        "-5 Résistance Neutre",
        "-6 Résistance Neutre",
        "-7 Résistance Neutre",
        "-8 Résistance Neutre",
        "-9 Résistance Neutre",
        "-10 Résistance Neutre",
        "-11 Résistance Neutre",
        "-12 Résistance Neutre",
        "-13 Résistance Neutre",
        "-14 Résistance Neutre",
        "-15 Résistance Neutre",
        "-16 Résistance Neutre",
        "-17 Résistance Neutre",
        "-18 Résistance Neutre",
        "-19 Résistance Neutre",
        "-20 Résistance Neutre"
    )
    var resistanceFixeNeutre: FromTo? = null

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonAlias(
        "Résistance Terre",
        "2 Résistance Terre",
        "3 Résistance Terre",
        "4 Résistance Terre",
        "5 Résistance Terre",
        "6 Résistance Terre",
        "7 Résistance Terre",
        "8 Résistance Terre",
        "9 Résistance Terre",
        "10 Résistance Terre",
        "11 Résistance Terre",
        "12 Résistance Terre",
        "13 Résistance Terre",
        "14 Résistance Terre",
        "15 Résistance Terre",
        "16 Résistance Terre",
        "17 Résistance Terre",
        "18 Résistance Terre",
        "19 Résistance Terre",
        "20 Résistance Terre",
        "40 Résistance Terre",
        "-1 Résistance Terre",
        "-2 Résistance Terre",
        "-3 Résistance Terre",
        "-4 Résistance Terre",
        "-5 Résistance Terre",
        "-6 Résistance Terre",
        "-7 Résistance Terre",
        "-8 Résistance Terre",
        "-9 Résistance Terre",
        "-10 Résistance Terre",
        "-11 Résistance Terre",
        "-12 Résistance Terre",
        "-13 Résistance Terre",
        "-14 Résistance Terre",
        "-15 Résistance Terre",
        "-16 Résistance Terre",
        "-17 Résistance Terre",
        "-18 Résistance Terre",
        "-19 Résistance Terre",
        "-20 Résistance Terre"
    )
    var resistanceFixeTerre: FromTo? = null

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonAlias(
        "Résistance Feu",
        "2 Résistance Feu",
        "3 Résistance Feu",
        "4 Résistance Feu",
        "5 Résistance Feu",
        "6 Résistance Feu",
        "7 Résistance Feu",
        "8 Résistance Feu",
        "9 Résistance Feu",
        "10 Résistance Feu",
        "11 Résistance Feu",
        "12 Résistance Feu",
        "13 Résistance Feu",
        "14 Résistance Feu",
        "15 Résistance Feu",
        "16 Résistance Feu",
        "17 Résistance Feu",
        "18 Résistance Feu",
        "19 Résistance Feu",
        "20 Résistance Feu",
        "40 Résistance Feu",
        "-1 Résistance Feu",
        "-2 Résistance Feu",
        "-3 Résistance Feu",
        "-4 Résistance Feu",
        "-5 Résistance Feu",
        "-6 Résistance Feu",
        "-7 Résistance Feu",
        "-8 Résistance Feu",
        "-9 Résistance Feu",
        "-10 Résistance Feu",
        "-11 Résistance Feu",
        "-12 Résistance Feu",
        "-13 Résistance Feu",
        "-14 Résistance Feu",
        "-15 Résistance Feu",
        "-16 Résistance Feu",
        "-17 Résistance Feu",
        "-18 Résistance Feu",
        "-19 Résistance Feu",
        "-20 Résistance Feu"
    )
    var resistanceFixeFeu: FromTo? = null

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonAlias(
        "Résistance Eau",
        "2 Résistance Eau",
        "3 Résistance Eau",
        "4 Résistance Eau",
        "5 Résistance Eau",
        "6 Résistance Eau",
        "7 Résistance Eau",
        "8 Résistance Eau",
        "9 Résistance Eau",
        "10 Résistance Eau",
        "11 Résistance Eau",
        "12 Résistance Eau",
        "13 Résistance Eau",
        "14 Résistance Eau",
        "15 Résistance Eau",
        "16 Résistance Eau",
        "17 Résistance Eau",
        "18 Résistance Eau",
        "19 Résistance Eau",
        "20 Résistance Eau",
        "40 Résistance Eau",
        "-1 Résistance Eau",
        "-2 Résistance Eau",
        "-3 Résistance Eau",
        "-4 Résistance Eau",
        "-5 Résistance Eau",
        "-6 Résistance Eau",
        "-7 Résistance Eau",
        "-8 Résistance Eau",
        "-9 Résistance Eau",
        "-10 Résistance Eau",
        "-11 Résistance Eau",
        "-12 Résistance Eau",
        "-13 Résistance Eau",
        "-14 Résistance Eau",
        "-15 Résistance Eau",
        "-16 Résistance Eau",
        "-17 Résistance Eau",
        "-18 Résistance Eau",
        "-19 Résistance Eau",
        "-20 Résistance Eau"
    )
    var resistanceFixeEau: FromTo? = null

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonAlias(
        "Résistance Air",
        "2 Résistance Air",
        "3 Résistance Air",
        "4 Résistance Air",
        "5 Résistance Air",
        "6 Résistance Air",
        "7 Résistance Air",
        "8 Résistance Air",
        "9 Résistance Air",
        "10 Résistance Air",
        "11 Résistance Air",
        "12 Résistance Air",
        "13 Résistance Air",
        "14 Résistance Air",
        "15 Résistance Air",
        "16 Résistance Air",
        "17 Résistance Air",
        "18 Résistance Air",
        "19 Résistance Air",
        "20 Résistance Air",
        "40 Résistance Air",
        "-1 Résistance Air",
        "-2 Résistance Air",
        "-3 Résistance Air",
        "-4 Résistance Air",
        "-5 Résistance Air",
        "-6 Résistance Air",
        "-7 Résistance Air",
        "-8 Résistance Air",
        "-9 Résistance Air",
        "-10 Résistance Air",
        "-11 Résistance Air",
        "-12 Résistance Air",
        "-13 Résistance Air",
        "-14 Résistance Air",
        "-15 Résistance Air",
        "-16 Résistance Air",
        "-17 Résistance Air",
        "-18 Résistance Air",
        "-19 Résistance Air",
        "-20 Résistance Air"
    )
    var resistanceFixeAir: FromTo? = null

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Prospection")
    var prospection: FromTo? = null

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Invocations")
    var invocations: FromTo? = null

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonAlias(
        "1% Résistance distance",
        "2% Résistance distance",
        "3% Résistance distance",
        "4% Résistance distance",
        "5% Résistance distance",
        "6% Résistance distance",
        "7% Résistance distance",
        "8% Résistance distance",
        "9% Résistance distance",
        "10% Résistance distance",
        "11% Résistance distance",
        "12% Résistance distance",
        "13% Résistance distance",
        "14% Résistance distance",
        "15% Résistance distance",
        "16% Résistance distance",
        "17% Résistance distance",
        "18% Résistance distance",
        "19% Résistance distance",
        "20% Résistance distance",
        "-1% Résistance distance",
        "-2% Résistance distance",
        "-3% Résistance distance",
        "-4% Résistance distance",
        "-5% Résistance distance",
        "-6% Résistance distance",
        "-7% Résistance distance",
        "-8% Résistance distance",
        "-9% Résistance distance",
        "-10% Résistance distance",
        "-11% Résistance distance",
        "-12% Résistance distance",
        "-13% Résistance distance",
        "-14% Résistance distance",
        "-15% Résistance distance",
        "-16% Résistance distance",
        "-17% Résistance distance",
        "-18% Résistance distance",
        "-19% Résistance distance",
        "-20% Résistance distance"
    )
    var pourcentResistanceDistance: FromTo? = null

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonAlias(
        "1% Résistance mêlée",
        "2% Résistance mêlée",
        "3% Résistance mêlée",
        "4% Résistance mêlée",
        "5% Résistance mêlée",
        "6% Résistance mêlée",
        "7% Résistance mêlée",
        "8% Résistance mêlée",
        "9% Résistance mêlée",
        "10% Résistance mêlée",
        "11% Résistance mêlée",
        "12% Résistance mêlée",
        "13% Résistance mêlée",
        "14% Résistance mêlée",
        "15% Résistance mêlée",
        "16% Résistance mêlée",
        "17% Résistance mêlée",
        "18% Résistance mêlée",
        "19% Résistance mêlée",
        "20% Résistance mêlée",
        "-1% Résistance mêlée",
        "-2% Résistance mêlée",
        "-3% Résistance mêlée",
        "-4% Résistance mêlée",
        "-5% Résistance mêlée",
        "-6% Résistance mêlée",
        "-7% Résistance mêlée",
        "-8% Résistance mêlée",
        "-9% Résistance mêlée",
        "-10% Résistance mêlée",
        "-11% Résistance mêlée",
        "-12% Résistance mêlée",
        "-13% Résistance mêlée",
        "-14% Résistance mêlée",
        "-15% Résistance mêlée",
        "-16% Résistance mêlée",
        "-17% Résistance mêlée",
        "-18% Résistance mêlée",
        "-19% Résistance mêlée",
        "-20% Résistance mêlée"
    )
    var pourcentResistanceMelee: FromTo? = null

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonAlias(
        "% Dommages mêlée",
        "2% Dommages mêlée",
        "3% Dommages mêlée",
        "4% Dommages mêlée",
        "5% Dommages mêlée",
        "6% Dommages mêlée",
        "7% Dommages mêlée",
        "8% Dommages mêlée",
        "9% Dommages mêlée",
        "10% Dommages mêlée",
        "11% Dommages mêlée",
        "12% Dommages mêlée",
        "13% Dommages mêlée",
        "14% Dommages mêlée",
        "15% Dommages mêlée",
        "16% Dommages mêlée",
        "17% Dommages mêlée",
        "18% Dommages mêlée",
        "19% Dommages mêlée",
        "20% Dommages mêlée",
        "-1% Dommages mêlée",
        "-2% Dommages mêlée",
        "-3% Dommages mêlée",
        "-4% Dommages mêlée",
        "-5% Dommages mêlée",
        "-6% Dommages mêlée",
        "-7% Dommages mêlée",
        "-8% Dommages mêlée",
        "-9% Dommages mêlée",
        "-10% Dommages mêlée",
        "-11% Dommages mêlée",
        "-12% Dommages mêlée",
        "-13% Dommages mêlée",
        "-14% Dommages mêlée",
        "-15% Dommages mêlée",
        "-16% Dommages mêlée",
        "-17% Dommages mêlée",
        "-18% Dommages mêlée",
        "-19% Dommages mêlée",
        "-20% Dommages mêlée"
    )
    var pourcentDommagesMelee: FromTo? = null

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonAlias(
        "% Dommages distance",
        "2% Dommages distance",
        "3% Dommages distance",
        "4% Dommages distance",
        "5% Dommages distance",
        "6% Dommages distance",
        "7% Dommages distance",
        "8% Dommages distance",
        "9% Dommages distance",
        "10% Dommages distance",
        "11% Dommages distance",
        "12% Dommages distance",
        "13% Dommages distance",
        "14% Dommages distance",
        "15% Dommages distance",
        "16% Dommages distance",
        "17% Dommages distance",
        "18% Dommages distance",
        "19% Dommages distance",
        "20% Dommages distance",
        "-1% Dommages distance",
        "-2% Dommages distance",
        "-3% Dommages distance",
        "-4% Dommages distance",
        "-5% Dommages distance",
        "-6% Dommages distance",
        "-7% Dommages distance",
        "-8% Dommages distance",
        "-9% Dommages distance",
        "-10% Dommages distance",
        "-11% Dommages distance",
        "-12% Dommages distance",
        "-13% Dommages distance",
        "-14% Dommages distance",
        "-15% Dommages distance",
        "-16% Dommages distance",
        "-17% Dommages distance",
        "-18% Dommages distance",
        "-19% Dommages distance",
        "-20% Dommages distance"
    )
    var pourcentDommagesDistance: FromTo? = null

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Puissance (pièges)")
    var puissancePieges: FromTo? = null

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Dommages Pièges")
    var dommagesPieges: FromTo? = null

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonAlias(
        "% Dommages aux sorts",
        "2% Dommages aux sorts",
        "3% Dommages aux sorts",
        "4% Dommages aux sorts",
        "5% Dommages aux sorts",
        "6% Dommages aux sorts",
        "7% Dommages aux sorts",
        "8% Dommages aux sorts",
        "9% Dommages aux sorts",
        "10% Dommages aux sorts",
        "11% Dommages aux sorts",
        "12% Dommages aux sorts",
        "13% Dommages aux sorts",
        "14% Dommages aux sorts",
        "15% Dommages aux sorts",
        "16% Dommages aux sorts",
        "17% Dommages aux sorts",
        "18% Dommages aux sorts",
        "19% Dommages aux sorts",
        "20% Dommages aux sorts",
        "-1% Dommages aux sorts",
        "-2% Dommages aux sorts",
        "-3% Dommages aux sorts",
        "-4% Dommages aux sorts",
        "-5% Dommages aux sorts",
        "-6% Dommages aux sorts",
        "-7% Dommages aux sorts",
        "-8% Dommages aux sorts",
        "-9% Dommages aux sorts",
        "-10% Dommages aux sorts",
        "-11% Dommages aux sorts",
        "-12% Dommages aux sorts",
        "-13% Dommages aux sorts",
        "-14% Dommages aux sorts",
        "-15% Dommages aux sorts",
        "-16% Dommages aux sorts",
        "-17% Dommages aux sorts",
        "-18% Dommages aux sorts",
        "-19% Dommages aux sorts",
        "-20% Dommages aux sorts"
    )
    var dommagesSorts: FromTo? = null

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("Pods")
    var pods: FromTo? = null

    fun hasVitalite(): Boolean {
        return vitalite != null
    }

    fun hasForce(): Boolean {
        return force != null
    }

    fun hasIntelligence(): Boolean {
        return intelligence != null
    }

    fun hasAgilite(): Boolean {
        return agilite != null
    }

    fun hasChance(): Boolean {
        return chance != null
    }

    fun hasPA(): Boolean {
        return pa != null
    }

    fun hasPM(): Boolean {
        return pm != null
    }

    fun hasPO(): Boolean {
        return po != null
    }

    fun hasCritique(): Boolean {
        return critique != null
    }

    fun hasPuissance(): Boolean {
        return puissance != null
    }

    private fun generateListOfAlias(aliasPrefix: String): List<String> {
        return (-20..20).map { it.toString() + aliasPrefix }
    }
}