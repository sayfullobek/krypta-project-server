package it.universal.krypta.valyuta.server.service;

import it.universal.krypta.valyuta.server.entity.Coins;
import it.universal.krypta.valyuta.server.logic.ServiceAbs;
import it.universal.krypta.valyuta.server.payload.Apiresponse;
import it.universal.krypta.valyuta.server.payload.CoinDto;
import it.universal.krypta.valyuta.server.repository.CoinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CoinService extends ServiceAbs {

    private final CoinRepository coinRepository;
    private final AttachmentService attachmentService;

    @Override
    public Apiresponse addCoin(CoinDto coinDto) {
        boolean existName = coinRepository.existsCoinsByNameEqualsIgnoreCase(coinDto.getName());
        if (existName) return new Apiresponse("bunday coin avvaldan mavjud", false);
        coinRepository.save(Coins.builder()
                .name(coinDto.getName())
                .photoId(coinDto.getPhotoId())
                .percentage(coinDto.getPercentage())
                .dollar(coinDto.getDollar())
                .active(true)
                .build());
        return new Apiresponse(coinDto.getName() + " nomli coin saqlandi", true);
    }

    @Override
    public Apiresponse editCoin(UUID id, CoinDto coinDto) {
        boolean existName = coinRepository.existsCoinsByNameEqualsIgnoreCaseAndIdNot(coinDto.getName(), id);
        if (existName) return new Apiresponse("bunday coin avvaldan mavjud", false);
        Coins coin = coinRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("getCoind"));
        attachmentService.deletePhoto(coin.getPhotoId());
        coin.setName(coinDto.getName());
        coin.setPhotoId(coinDto.getPhotoId());
        coin.setPercentage(coinDto.getPercentage());
        coin.setDollar(coinDto.getDollar());
        coinRepository.save(coin);
        return new Apiresponse(coin.getName() + " nomli coin " + coinDto.getName() + " ga taxrirlandi", true);
    }

    @Override
    public Apiresponse deleteCoin(UUID id) {
        Coins coin = coinRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("getCoind"));
        coinRepository.delete(coin);
        return new Apiresponse(coin.getName() + " nomli coin o'chirildi", true);
    }
}
