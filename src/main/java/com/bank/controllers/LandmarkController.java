package com.bank.controllers;

import com.bank.dto.ImageDTO;
import com.bank.dto.LandmarkDTO;
import com.bank.models.Image;
import com.bank.models.Landmark;
import com.bank.service.LandmarkService;
import com.bank.utils.mappers.impl.ImageMapper;
import com.bank.utils.mappers.impl.LandmarkMapper;
import com.bank.validators.LandmarkDTOValidator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/landmarks")
@RequiredArgsConstructor
@Tag(name = "Landmark Controller", description = "Landmark API")
public class LandmarkController extends MainController {

    private final LandmarkService landmarkService;
    private final LandmarkMapper landmarkMapper;
    private final LandmarkDTOValidator landmarkDTOValidator;
    private final ImageMapper imageMapper;

    @Operation(summary = "Get all landmarks")
    @GetMapping
    public ResponseEntity<Object> getAll(
            @RequestParam(required = false) Optional<String> prefix,
            @RequestParam(required = false) Optional<Integer> limit) {

        List<Landmark> all;

        if (prefix.isPresent()) {
            all = landmarkService.findAllByTitleStartingWith(prefix.get().trim()); // вместо проверки просто trim
        } else {
            all = landmarkService.getAll();
        }

        return ResponseEntity
                .ok()
                .body(landmarkMapper.toDTOs(all).subList(0, limit.orElse(all.size())));  // может не хватать одного элемента
    }

    @Operation(summary = "Get landmark by id")
    @GetMapping("/{landmark_id}")
    public ResponseEntity<Object> getById(
            @PathVariable("landmark_id") Long id) {
        return new ResponseEntity<>(landmarkMapper.toDTO(landmarkService.getById(id)), HttpStatus.OK);
    }

    @Operation(summary = "Create landmark")
    @PostMapping("/create")
    public ResponseEntity<Object> createNewLandmark(
            @RequestBody @Valid LandmarkDTO landmarkDTO, BindingResult bindingResult) {
        landmarkDTOValidator.validate(landmarkDTO, bindingResult);
        checkBindingResult(bindingResult);

        landmarkService.save(landmarkMapper.fromDTO(landmarkDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{address}")
    public Landmark getByAddress(@PathVariable("address") String address) {
        return landmarkService.findByAddress(address);
    }

    @PostMapping("/{id}/update")
    public ResponseEntity<Object> update(
            @PathVariable("id") int id,
            @RequestBody @Valid LandmarkDTO landmarkDTO,
            BindingResult bindingResult) {

        landmarkDTOValidator.validate(landmarkDTO, bindingResult);
        checkBindingResult(bindingResult);

        landmarkService.update(id, landmarkMapper.fromDTO(landmarkDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Operation(summary = "Get all images for landmark by landmark id")
    @GetMapping("/{landmark_id}/images")
    public ResponseEntity<Object> getAllImagesForPost(@PathVariable("landmark_id") Long landmarkId) {
        return new ResponseEntity<>(landmarkService.getById(landmarkId).getImages(), HttpStatus.OK);
    }

    @Operation(summary = "Add image for landmark by landmark id")
    @PostMapping("/{landmark_id}/images/add")
    public ResponseEntity<Object> uploadImageForPost(@PathVariable("landmark_id") Long postId,
                                                     @ModelAttribute ImageDTO imageDTO) {
        Image image = imageMapper.fromDTO(imageDTO);
        landmarkService.uploadImage(postId, image);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Delete image for landmark by landmark id")
    @DeleteMapping("/{landmark_id}/images/delete")
    @ResponseStatus(HttpStatus.OK)
    //  @PreAuthorize("@customSecurityExpression.isPostOwner(#postId)") TODO
    public void deleteImage(@PathVariable("landmark_id") Long postId,
                            @RequestBody String jsonRequest) {
        JSONObject jsonObject = new JSONObject(jsonRequest);
        String name = jsonObject.getString("name");
        landmarkService.deleteImage(postId, name);
    }

}
