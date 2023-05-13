package it.universal.krypta.valyuta.server.service;

import it.universal.krypta.valyuta.server.entity.VIPS;
import it.universal.krypta.valyuta.server.logic.ServiceAbs;
import it.universal.krypta.valyuta.server.payload.Apiresponse;
import it.universal.krypta.valyuta.server.payload.VipsDto;
import it.universal.krypta.valyuta.server.repository.VipsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VipsServise extends ServiceAbs {
    private final VipsRepository vipsRepository;

    @Override
    public Apiresponse addVips(VipsDto vipsDto) {
        boolean existName = vipsRepository.existsVIPSByEnNameAndRuNameAndUzNameEqualsIgnoreCase(vipsDto.getUzName(), vipsDto.getRuName(), vipsDto.getEnName());
        if (existName) return new Apiresponse("Bunday vip avvaldan mavjud", false);
        vipsRepository.save(VIPS.builder()
                .photoId(vipsDto.getPhotoId())
                .minQuantifyAmount(vipsDto.getMinQuantifyAmount())
                .maxQuantifyAmount(vipsDto.getMaxQuantifyAmount())
                .shareRatio(vipsDto.getShareRatio())
                        .effectiveEmount(vipsDto.getEffectiveEmount())
                        .directlyPromoteMembers(vipsDto.getDirectlyPromoteMembers())
                        .secondThridGenerationMembers(vipsDto.getSecondThridGenerationMembers())
                        .profits(vipsDto.getProfits())
                        .metaGORobotsAvailablePerDay(vipsDto.getMetaGORobotsAvailablePerDay())
                        .teamAward(vipsDto.getTeamAward())
                        .active(true)
                .build()
        );
        return new Apiresponse(vipsDto.getUzName()+"nomli VIp saqlandi",true) ;
    }

    @Override
    public Apiresponse editVips(Integer id, VipsDto vipsDto) {
        boolean existName = vipsRepository.existsVIPSByEnNameAndRuNameAndUzNameEqualsIgnoreCase(vipsDto.getUzName(), vipsDto.getRuName(), vipsDto.getEnName());
        if (existName) return new Apiresponse("Bunday vip avvaldan mavjud", false);
        VIPS vips=vipsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("getVIPS"));
        vips.setUzName(vipsDto.getUzName());
        vips.setEnName(vipsDto.getEnName());
        vips.setRuName(vips.getRuName());
        vipsRepository.save(vips);
        return new Apiresponse(vips.getUzName()+" nomli vips "+ vipsDto.getUzName()+" ga Taxrirlandi",true);
    }

    @Override
    public Apiresponse deleteVips(Integer id) {
        VIPS vips=vipsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("getVIPS"));
        vipsRepository.delete(vips);
        return new Apiresponse(vips.getUzName()+" nomli vips o'chirildi",true);
    }
}
