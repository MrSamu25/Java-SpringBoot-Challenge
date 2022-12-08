package com.accenture.challenge.business;

import com.accenture.challenge.entity.SharedAlbumEntity;
import com.accenture.challenge.exception.BusinessException;
import com.accenture.challenge.mapper.SharedAlbumMapper;
import com.accenture.challenge.model.sharedAlbum.SharedAlbum;
import com.accenture.challenge.model.sharedAlbum.SharedAlbumAbstract;
import com.accenture.challenge.model.sharedAlbum.SharedAlbumUpdate;
import com.accenture.challenge.repository.AlbumRepository;
import com.accenture.challenge.repository.SharedAlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SharedAlbumBusinessImpl implements SharedAlbumBusiness {

    @Autowired
    private SharedAlbumRepository sharedAlbumRepository;
    @Autowired
    private AlbumRepository albumRepository;

    @Override
    public List<SharedAlbumEntity> getAllSharedAlbum() {
        return sharedAlbumRepository.findAll();
    }

    @Override
    public SharedAlbum saveSharedAlbum(SharedAlbum sharedAlbum) throws BusinessException {
        validationsBeforeSaveSharedAlbum(sharedAlbum);
        SharedAlbumEntity sharedAlbumEntity = SharedAlbumMapper.mapper.sharedAlbumToSharedAlbumEntity(sharedAlbum);
        sharedAlbumEntity = sharedAlbumRepository.save(sharedAlbumEntity);
        return SharedAlbumMapper.mapper.sharedAlbumEntityToSharedAlbum(sharedAlbumEntity);
    }

    @Override
    public SharedAlbumUpdate updateSharedAlbum(SharedAlbumUpdate sharedAlbumUpdate) throws BusinessException {
        validationsBeforeSaveSharedAlbum(sharedAlbumUpdate);

        SharedAlbumEntity sharedAlbumEntity =
                SharedAlbumMapper.mapper.sharedAlbumUpdateToSharedAlbumEntity(sharedAlbumUpdate);

        if (sharedAlbumRepository.findById(sharedAlbumUpdate.getId()).isEmpty()) {
            throw new BusinessException("Shared Album does not exists");
        }

        sharedAlbumEntity = sharedAlbumRepository.save(sharedAlbumEntity);
        return SharedAlbumMapper.mapper.sharedAlbumEntityToSharedAlbumUpdate(sharedAlbumEntity);
    }

    private void validationsBeforeSaveSharedAlbum(SharedAlbumAbstract sharedAlbumAbstract) throws BusinessException {
        if (sharedAlbumAbstract.getUserIdSource().equals(sharedAlbumAbstract.getUserIdDestination())) {
            throw new BusinessException("userIdSource and userIdDestination can not be the same");
        }



        if (albumRepository.findByIdAndUserId(sharedAlbumAbstract.getAlbumId(),
                sharedAlbumAbstract.getUserIdSource()).isEmpty()) {
            StringBuilder sb = new StringBuilder("Source user with id: ");
            sb.append(sharedAlbumAbstract.getUserIdSource());
            sb.append(" doesn't has album with id: ");
            sb.append(sharedAlbumAbstract.getAlbumId());
            throw new BusinessException(sb.toString());
        }
    }
}

