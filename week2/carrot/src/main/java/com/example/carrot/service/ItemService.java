package com.example.carrot.service;

import com.example.carrot.common.exception.BusinessException;
import com.example.carrot.common.exception.ErrorStatus;
import com.example.carrot.domain.Category;
import com.example.carrot.domain.Item;
import com.example.carrot.domain.User;
import com.example.carrot.dto.request.ItemCreateRequest;
import com.example.carrot.repository.ItemRepository;
import com.example.carrot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ItemService {
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;

    @Transactional
    public void createItem(ItemCreateRequest request) {
        User findUser = getUser(request.userId());
        Category category = getCategory(request.category());
        Item item = Item.createItem(request.title(), request.price(), request.suggestion(), request.description(), category, request.local(), findUser);
        itemRepository.save(item);
    }

    private User getUser(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new BusinessException(ErrorStatus.USER_NOT_FOUND));
    }

    private Category getCategory(String category) {
        return Category.valueOf(category);
    }
}
