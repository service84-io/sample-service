/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.service84.permission.api.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.service84.services.sample.api.ProverbApiDelegate;
import io.service84.services.sample.dto.ProverbDTO;

@Service("AAAD395F-8B29-414E-ACBE-E39A55CC2620")
public class ProverbDelegate implements ProverbApiDelegate {
  private Map<UUID, ProverbDTO> proverbs;
  private static Random random = new Random();

  public ProverbDelegate() {
    proverbs = new HashMap<UUID, ProverbDTO>();
    addMockProverb("A bird in the hand is worth two in the bush.");
    addMockProverb("An apple a day keeps the doctor away");
    addMockProverb("Better to have loved and lost than never to have loved at all");
    addMockProverb("Loose lips sink ships");
    addMockProverb("Necessity is the mother of invention");
    addMockProverb("No news is good news");
    addMockProverb("Enough Rope to Shoot Yourself in the Foot");
  }

  private void addMockProverb(String proverb) {
    ProverbDTO dto = new ProverbDTO();
    dto.setProverb(proverb);
    dto.setId(UUID.randomUUID());
    proverbs.put(dto.getId(), dto);
  }

  private UUID getRandomProverbID() {
    List<UUID> keys = new ArrayList<>(proverbs.keySet());
    Integer randomIndex = random.nextInt(keys.size());
    return keys.get(randomIndex);
  }

  @Override
  public ResponseEntity<ProverbDTO> getProverb(UUID id) {
    if (proverbs.containsKey(id)) {
      return new ResponseEntity<>(proverbs.get(id), HttpStatus.OK);
    }
    // TODO Use the Service84 Exceptional Result Library to return the appropriate DTO
    return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
  }

  @Override
  public ResponseEntity<ProverbDTO> getRandomProverb() {
    return new ResponseEntity<>(proverbs.get(getRandomProverbID()), HttpStatus.OK);
  }
}
