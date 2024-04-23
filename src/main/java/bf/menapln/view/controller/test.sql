SELECT c.*,i.*,sess.*,option.*,str.*,concour.*,typeCa.*,
        pay.pays_id,pay.indicatif,pay.nomPays,payNat.pays_id as nationalite_id,payNat.nationalite,
        zo.localite_id as zone_id,zo.nomLocalite as nom_zone,
        -- vilcompo.centre_identifiant as centrId,
        vilcompo.centre_id as centrId,
        -- centreExam.localite_id as centreExamenId,centreExam.nomLocalite as nomCentre,
        --typLoca.typeLocalite_id as centreType,
        --typLo.typeLocaliteLibelle as libelleTypeLocal,
        -- commu.localite_id as commune_id,commu.nomLocalite as nom_commune,
        -- provi.localite_id as province_id,provi.nomLocalite as nom_province,
        -- regio.localite_id as region_id,regio.nomLocalite as nom_region,
        tpInsc.typeInscription_id as typeInsc_id,tpInsc.typeInscriptionLibelle as typeInsc_libelle,
        gp.groupePedagogique_id as gp_id,gp.groupePedagogiqueLibelle as gp_libelle
        -- ,tpSit.typeSituation_id as tpSituation_id,tpSit.typeSituationLibelle as tpSituation_libelle,
        -- prescH.prescription_id as presci_id,prescH.prescriptionLibelle as presci_libelle,
        -- natureH.natureHandicap_id as natureH_id,natureH.natureHandicapLibelle as natureH_libelle,
        -- typeH.typeHandicap_id as typeH_id,typeH.typeHandicapLibelle as typeH_libelle,
        -- chCan.choixEtablissement_id as etabChoix_id, choixEtabCandi.nomStructure as etabChoix_nom,
        -- chCan.serie_id as serieChoix,choixSerieCandi.serieLibelle
        	    FROM candidat c
        INNER JOIN inscription i ON i.candidat_id = c.candidat_id and c.numeroDossier = i.numeroDossier and c.etablissement_id = i.etablissement_id
        INNER JOIN structure str ON str.structure_id = i.etablissement_id
        INNER JOIN session sess ON sess.session_id = i.session_id
        INNER JOIN localite zo ON zo.localite_id = i.zone_id
        -- INNER JOIN centre vilcompo ON vilcompo.centre_identifiant = i.centreExamen_Id and vilcompo.centre_id = i.centre_id and vilcompo.localite_id = i.localite_id
        INNER JOIN centre vilcompo ON vilcompo.centre_id = i.centre_id and vilcompo.localite_id = i.localite_id
        --inner join localite typLoca on typLoca.localite_id = vilcompo.localite_id
        --INNER JOIN typeLocalite typLo ON typLO.typeLocalite_id = typLoca.typeLocalite_id
        -- inner join localite centreExam on centreExam.localite_id = vilcompo.centre_id
        -- LEFT JOIN localite commu ON commu.localite_id = vilcompo.localite_id
        -- LEFT JOIN localite provi ON provi.localite_id = commu.parentLocalite
        -- LEFT JOIN localite regio ON regio.localite_id = provi.parentLocalite
        INNER JOIN option ON option.option_id = i.option_id
        INNER JOIN concoursRattache concour ON concour.concoursRattache_id = i.concoursRattache
        INNER JOIN typeCandidat typeCa ON typeCa.typeCandidat_id = i.typeCandidat_id
        INNER JOIN pays pay ON pay.pays_id = c.paysNaissance_id
        INNER JOIN pays payNat ON payNat.pays_id = c.paysNationalite_id
        INNER JOIN typeInscription tpInsc ON tpInsc.typeInscription_id = i.typeInscription_id
        INNER JOIN groupePedagogique gp ON gp.groupePedagogique_id = i.groupePedagogique_id and gp.etablissement_id = i.etablissement_id
        -- INNER JOIN typeSituation tpSit	ON tpSit.typeSituation_id = i.typeSituation_id
        -- LEFT JOIN prescription prescH ON prescH.prescription_id = i.prescription_id
        -- LEFT JOIN natureHandicap natureH ON natureH.natureHandicap_id = i.natureHandicap_id
        -- LEFT JOIN typeHandicap typeH ON typeH.typeHandicap_id = natureH.typeHandicap_id
        -- LEFT JOIN choixCandidat chCan ON chCan.candidat_id = i.candidat_id and chCan.numeroDossier = i.numeroDossier and chCan.etablissement_id = i.etablissement_id
        -- LEFT JOIN structure choixEtabCandi ON choixEtabCandi.structure_id = chCan.choixEtablissement_id
        -- LEFT JOIN serie choixSerieCandi ON choixSerieCandi.serie_id = chCan.serie_id