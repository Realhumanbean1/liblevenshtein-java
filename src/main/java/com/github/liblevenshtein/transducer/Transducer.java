package com.github.liblevenshtein.transducer;

import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * This wrapper around {@link LazyTransducerCollection}, which handles all the
 * heavy lifting.
 *
 * @author Dylon Edwards
 * @param <DictionaryNode> Kind of nodes of the dictionary automaton.
 * @param <CandidateType> Kind of the spelling candidates returned from the
 *   dictionary.
 * @since 2.1.0
 */
@Data
@RequiredArgsConstructor
public class Transducer<DictionaryNode, CandidateType>
  implements ITransducer<CandidateType>, Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * Attributes required for this transducer to search the dictionary.
   */
  @Getter
  @NonNull
  private TransducerAttributes<DictionaryNode, CandidateType> attributes;

  /**
   * {@inheritDoc}
   */
  @Override
  public Iterable<CandidateType> transduce(@NonNull final String term) {
    return transduce(term, attributes.maxDistance());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Iterable<CandidateType> transduce(
      @NonNull final String term,
      final int maxDistance) {
    return new LazyTransducerCollection<DictionaryNode, CandidateType>(
        term, maxDistance, attributes);
  }
}
